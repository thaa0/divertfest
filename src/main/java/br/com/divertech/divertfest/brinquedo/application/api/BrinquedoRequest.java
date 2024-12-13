package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Categoria;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BrinquedoRequest {
    private String nome;
    private String descricao;
    private Categoria categoria;
    private String imagem;
}