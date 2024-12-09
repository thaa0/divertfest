package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LocadorCriadoResponse {
    private UUID idUsuario;
    private String email;
    private StatusUsuario status;

    public void UsuarioCriadoResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.email = usuario.getEmail();
        this.status = usuario.getStatus();
    }
}
