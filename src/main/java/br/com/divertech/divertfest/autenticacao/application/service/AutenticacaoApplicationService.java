package br.com.divertech.divertfest.autenticacao.application.service;

import br.com.divertech.divertfest.autenticacao.domain.Token;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.credencial.application.service.CredencialApplicationService;
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
    private final CredencialApplicationService credencialService;

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoService - autentica");
        var authentication = authenticationManager.authenticate(userCredentials);
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenService.gerarToken(authentication))
                .build();
        log.info("[finaliza] AutenticacaoService - autentica");
        return token;
    }
}
