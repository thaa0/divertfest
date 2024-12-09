package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Categoria;
import br.com.divertech.divertfest.brinquedo.domain.StatusBrinquedo;
import br.com.divertech.divertfest.locador.domain.Locador;

import java.util.UUID;

public class BrinquedoRequest {
    private String nome;
    private String descricao;
    private Categoria categoria;
    private StatusBrinquedo status;
    private String imagem;
    private UUID donoBrinquedo;
}