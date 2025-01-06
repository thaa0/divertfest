package br.com.divertech.divertfest.carrinho.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.OK)
    void agendaBrinquedo(@RequestHeader(name = "Authorization") String token, @RequestBody ItemRequest item);
}