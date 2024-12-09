package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.locatario.domain.Locatario;
import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LocatarioCriadoResponse {
    private UUID idUsuario;
    private String email;
    private StatusUsuario status;

    public LocatarioCriadoResponse(Locatario locatario) {
        this.idUsuario = locatario.getIdUsuario();
        this.email = locatario.getEmail();
        this.status = locatario.getStatus();
    }
}
