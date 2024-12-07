package br.com.divertech.divertfest.autenticacao.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/public/v1/autenticacao")
public interface AutenticacaoAPI {

    @Operation(summary = "Autenticação do usuário",
            description = "Realiza a autenticação do usuário com nome de usuário e senha.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Autenticação bem-sucedida"),
                    @ApiResponse(responseCode = "401", description = "Usuário ou senha inválidos")
            })
    @PostMapping("/autentica")
    @ResponseStatus(HttpStatus.OK)
    TokenResponse autentica(@RequestBody @Valid AutenticacaoRequest autenticacaoRequest) throws AuthenticationException;
}