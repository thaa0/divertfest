package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Categoria;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class BrinquedoEditaRequest {
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal precoPorHora;
}
