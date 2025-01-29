package br.com.divertech.divertfest.autenticacao.application.service;

import br.com.divertech.divertfest.autenticacao.application.api.TokenResponse;
import br.com.divertech.divertfest.autenticacao.domain.Token;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.credencial.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoApplicationService implements AutenticacaoService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public TokenResponse autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoService - autentica");
        var authentication = authenticationManager.authenticate(userCredentials);
        String tokenGerado = tokenService.gerarToken(authentication);
        String role = tokenService.obterRoleDoToken(tokenGerado);
        log.info("Role do usuário: {}", role);  // Se precisar fazer algo com a role
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenGerado)
                .build();
        log.info("[finaliza] AutenticacaoService - autentica");
        return new TokenResponse(token,role);
    }

}
