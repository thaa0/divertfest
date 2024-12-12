package br.com.divertech.divertfest.locatario.application.service;

import br.com.divertech.divertfest.locatario.application.api.LocatarioCriadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioDetalhadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;

import java.util.UUID;

public interface LocatarioService {
    LocatarioCriadoResponse cadastraLocatario(LocatarioNovoRequest locatarioNovo);
    LocatarioDetalhadoResponse buscaLocatario(String email);
    LocatarioDetalhadoResponse buscaLocatarioPorId(UUID idLocatario);
    void suspendeLocatario(UUID idLocatario);
    void ativaLocatario(UUID idLocatario);
}