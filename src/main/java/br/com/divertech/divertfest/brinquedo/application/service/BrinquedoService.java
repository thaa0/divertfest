package br.com.divertech.divertfest.brinquedo.application.service;

import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoEditaRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoResponse;

import java.util.List;
import java.util.UUID;

public interface BrinquedoService {
    BrinquedoResponse cadastra(String emailLocador, BrinquedoRequest brinquedoRequest);
    void edita(String emailLocador,UUID idBrinquedo, BrinquedoEditaRequest brinquedoRequest);
    BrinquedoResponse buscaBrinquedoPorId(UUID idBrinquedo);
    void apaga(String emailLocador, UUID idBrinquedo);
    List<BrinquedoResponse> listaBrinquedos();
    List<BrinquedoResponse> buscaBrinquedoPorNome(String nome);
}
