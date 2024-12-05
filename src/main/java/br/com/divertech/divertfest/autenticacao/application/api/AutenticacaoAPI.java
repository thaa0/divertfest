package br.com.divertech.divertfest.autenticacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/public/v1/autenticacao")
public interface AutenticacaoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    TokenResponse autentica(@RequestBody @Valid AutenticacaoRequest autenticacaoRequest) throws AuthenticationException;
}