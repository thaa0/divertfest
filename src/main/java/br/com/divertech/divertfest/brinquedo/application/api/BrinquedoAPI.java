package br.com.divertech.divertfest.brinquedo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/")
public interface BrinquedoAPI {

    @PostMapping("locador/brinquedo")
    @ResponseStatus(HttpStatus.CREATED)
    BrinquedoResponse cadastraBrinquedo(BrinquedoRequest brinquedoRequest);
}
