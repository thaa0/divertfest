package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BrinquedoResponse {
    private UUID idBrinquedo;
    private UUID idDono;
    private String dono;

    public BrinquedoResponse(Brinquedo brinquedo) {
        this.idBrinquedo = brinquedo.getIdBrinquedo();
        this.idDono = brinquedo.getDonoBrinquedo().getIdUsuario();
        this.dono = brinquedo.getDonoBrinquedo().getNome();
    }
}