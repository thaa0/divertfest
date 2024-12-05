package br.com.divertech.divertfest.config.security;

import br.com.divertech.divertfest.config.security.domain.ValidaConteudoAuthorizationHeader;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final CredencialService credencialService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("[start] FiltroToken - doFilterInternal");
        String token = recuperaToken(request);
        autenticaCliente(token);
        log.debug("[finish] FiltroToken - doFilterInternal");
        filterChain.doFilter(request, response);
    }

    private String recuperaToken(HttpServletRequest request) {
        log.info("[inicio] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        var AuthorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationHeader(request));
        String AuthorizationHeaderValue = AuthorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader())
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        log.info("[finaliza] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        return AuthorizationHeaderValue.substring(7);
    }

    private String recuperaValorAuthorizationHeader(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .orElseThrow(() -> new RuntimeException("Token não está presente na requisição!"));
    }

    private void autenticaCliente(String token) {
        log.info("[inicio] autenticacaoCliente - utilizando token válido para autenticar o usuário");
        Credencial credencial = recuperaUsuario(token);
        var authenticationToken = new UsernamePasswordAuthenticationToken(credencial, null, credencial.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("[finaliza] autenticacaoCliente - utilizando token válido para autenticar o usuário");
    }

    private Credencial recuperaUsuario(String token) {
        String usuario = tokenService.getUsuario(token).orElseThrow(()-> new RuntimeException("O Token enviado está inválido. Tente novamente."));
        return credencialService.buscaCredencialPorUsuario(usuario);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/public/")||path.contains("/swagger-ui/");
    }
}
