package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LocadorCriadoResponse {
    private UUID idUsuario;
    private String email;
    private StatusUsuario status;

    public LocadorCriadoResponse(Locador locador) {
        this.idUsuario = locador.getIdUsuario();
        this.email = locador.getEmail();
        this.status = locador.getStatus();
    }
}
