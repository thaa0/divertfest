package br.com.divertech.divertfest.usuario.application.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UsuarioNovoRequest {
    @Email
    private final String email;
    @Size(min = 6)
    private final String senha;
}