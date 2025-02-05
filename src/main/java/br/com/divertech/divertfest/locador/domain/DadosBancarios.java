package br.com.divertech.divertfest.locador.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class DadosBancarios {
    private String nomeDoTitular;
    private String chavePix;
}
