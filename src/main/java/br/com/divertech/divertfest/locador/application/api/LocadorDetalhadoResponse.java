package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.credencial.domain.Role;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import lombok.Getter;

import java.util.UUID;


@Getter
public class LocadorDetalhadoResponse {
    private UUID idUsuario;
    private String razaoSocial;
    private String telefone;
    private String documentoIdentificador;
    private Role tipoUsuario;
    private StatusUsuario status;

    public LocadorDetalhadoResponse(Locador locador) {
        this.idUsuario = locador.getIdUsuario();
        this.razaoSocial = locador.getRazaoSocial();
        this.telefone = locador.getTelefone();
        this.documentoIdentificador = locador.getDocumentoIdentificador();
        this.tipoUsuario = locador.getTipoUsuario();
        this.status = locador.getStatus();
    }
}
