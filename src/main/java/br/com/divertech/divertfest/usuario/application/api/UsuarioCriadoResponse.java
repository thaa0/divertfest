package br.com.divertech.divertfest.usuario.application.api;

import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.Getter;

import java.util.UUID;


@Getter
public class UsuarioCriadoResponse {
    private final UUID idUsuario;
    private final String email;
    private final StatusUsuario status;

    public UsuarioCriadoResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.email = usuario.getEmail();
        this.status = usuario.getStatus();
    }
}