package br.com.divertech.divertfest.locador.application.service;
import br.com.divertech.divertfest.locador.application.api.LocadorCriadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;

public interface LocadorService {
    LocadorCriadoResponse cadastraLocador(LocadorNovoRequest locadorNovo);
}