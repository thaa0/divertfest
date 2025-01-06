package br.com.divertech.divertfest.carrinho.application.api;

import br.com.divertech.divertfest.carrinho.application.service.CarrinhoService;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CarrinhoController implements CarrinhoAPI {

    private final TokenService tokenService;
    private final CarrinhoService carrinhoService;

    @Override
    public void agendaBrinquedo(String token, ItemRequest item) {
        log.info("[start] CarrinhoController - agendaBrinquedo");
        String locatario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        carrinhoService.adicionaItemAoCarrinho(locatario, item);
        log.debug("[finish] CarrinhoController - agendaBrinquedo");
    }
}
