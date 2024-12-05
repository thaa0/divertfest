package br.com.divertech.divertfest.autenticacao.application.service;

import br.com.divertech.divertfest.autenticacao.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
}
