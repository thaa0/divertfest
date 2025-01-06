package br.com.divertech.divertfest.carrinho.application.service;

import br.com.divertech.divertfest.carrinho.application.api.ItemRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CarrinhoApplicationService implements CarrinhoService {
    @Override
    public void adicionaItemAoCarrinho(String locatario, ItemRequest item) {
        log.info("[start] CarrinhoApplicationService - adicionaItemAoCarrinho");

        log.debug("[finish] CarrinhoApplicationService - adicionaItemAoCarrinho");
    }
}
