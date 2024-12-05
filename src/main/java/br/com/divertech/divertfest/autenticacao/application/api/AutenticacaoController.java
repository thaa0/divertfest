package br.com.divertech.divertfest.autenticacao.application.api;

import br.com.divertech.divertfest.autenticacao.application.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AutenticacaoController implements AutenticacaoAPI {

    private final AutenticacaoService autenticacaoService;

    @Override
    public TokenResponse autentica(AutenticacaoRequest autenticacaoRequest) throws AuthenticationException {
        log.info("[start] AutenticacaoController - autentica");
        var token = autenticacaoService.autentica(autenticacaoRequest.getUserPassToken());
        log.debug("[finish] AutenticacaoController - autentica");
        return new TokenResponse(token);
    }
}
