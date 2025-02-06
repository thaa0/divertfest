package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.locador.domain.DadosBancarios;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.Email;

@Getter
public class LocadorEditaRequest {
    @Embedded
    private DadosBancarios dadosBancarios;
}
