package br.com.divertech.divertfest.autenticacao.domain;

import br.com.divertech.divertfest.credencial.domain.Role;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {
    private String token;
    private String tipo;
}
