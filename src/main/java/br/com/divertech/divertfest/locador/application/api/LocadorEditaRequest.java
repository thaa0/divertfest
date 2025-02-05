package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.locador.domain.DadosBancarios;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.Email;

@Getter
public class LocadorEditaRequest {
    private String nome;
    private String razaoSocial;
    private String telefone;
    private String endereco;
    @Embedded
    private DadosBancarios dadosBancarios;
}
