package br.com.divertech.divertfest.carrinho.application.service;


import br.com.divertech.divertfest.carrinho.application.api.ItemRequest;

public interface CarrinhoService {
    void adicionaItemAoCarrinho(String locatario, ItemRequest item);
}
