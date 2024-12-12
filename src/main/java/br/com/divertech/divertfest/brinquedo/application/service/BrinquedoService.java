package br.com.divertech.divertfest.brinquedo.application.service;

import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoResponse;

public interface BrinquedoService {
    BrinquedoResponse cadastra(BrinquedoRequest brinquedoRequest);

    void edita(String idBrinquedo, BrinquedoRequest brinquedoRequest);

    BrinquedoResponse buscaBrinquedoPorId(String idBrinquedo);
}
