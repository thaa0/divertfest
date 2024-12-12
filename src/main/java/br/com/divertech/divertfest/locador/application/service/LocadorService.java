package br.com.divertech.divertfest.locador.application.service;
import br.com.divertech.divertfest.locador.application.api.LocadorCriadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorDetalhadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;

import java.util.UUID;

public interface LocadorService {
    LocadorCriadoResponse cadastraLocador(LocadorNovoRequest locadorNovo);
    LocadorDetalhadoResponse buscaLocadorPorEmail(String email);
    LocadorDetalhadoResponse buscaLocadorPorId(UUID idLocador);
    void ativaLocador(UUID idLocador);
    void suspendeLocador(UUID idLocador);
    void checaLocadorSuspenso(UUID idLocador);
}