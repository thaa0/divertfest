package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
public class BrinquedoResponse {
    private UUID idBrinquedo;
    private UUID idDono;
    private String dono;
    private String nome;
    private String status;
    private BigDecimal preco;

    public BrinquedoResponse(Brinquedo brinquedo) {
        this.idBrinquedo = brinquedo.getIdBrinquedo();
        this.idDono = brinquedo.getDonoBrinquedo().getIdUsuario();
        this.dono = brinquedo.getDonoBrinquedo().getNome();
        this.nome = brinquedo.getNome();
        this.status = brinquedo.getStatus().name();
        this.preco = brinquedo.getPrecoPorHora();
    }

    public static List<BrinquedoResponse> converte(List<Brinquedo> brinquedos) {
        return brinquedos.stream().map(BrinquedoResponse::new).toList();
    }
}