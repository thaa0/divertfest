package br.com.divertech.divertfest.autenticacao.application.service;

import br.com.divertech.divertfest.autenticacao.application.api.TokenResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoService {
    TokenResponse autentica(UsernamePasswordAuthenticationToken userCredentials);
}
