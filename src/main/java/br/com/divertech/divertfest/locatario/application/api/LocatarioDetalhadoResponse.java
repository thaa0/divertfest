package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.credencial.domain.Role;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import br.com.divertech.divertfest.usuario.common.StatusUsuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LocatarioDetalhadoResponse {
    private UUID idUsuario;
    private String telefone;
    private String documentoIdentificador;
    private Role tipoUsuario;
    private StatusUsuario status;

    public LocatarioDetalhadoResponse(Locatario locatario) {
        this.idUsuario = locatario.getIdUsuario();
        this.telefone = locatario.getTelefone();
        this.documentoIdentificador = locatario.getDocumentoIdentificador();
        this.tipoUsuario = locatario.getTipoUsuario();
        this.status = locatario.getStatus();
    }
}
