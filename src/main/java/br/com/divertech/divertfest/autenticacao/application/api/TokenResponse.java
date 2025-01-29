package br.com.divertech.divertfest.autenticacao.application.api;

import br.com.divertech.divertfest.autenticacao.domain.Token;
import br.com.divertech.divertfest.credencial.domain.Role;
import lombok.Value;


@Value
public class TokenResponse {
    private String token;
    private String tipo;
    private String role;

    public TokenResponse(Token token, String role) {
        this.token = token.getToken();
        this.tipo = token.getTipo();
        this.role = role;

    }
}