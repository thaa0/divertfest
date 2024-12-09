package br.com.divertech.divertfest.locatario.application.service;

import br.com.divertech.divertfest.locatario.application.api.LocatarioCriadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;

public interface LocatarioService {
    LocatarioCriadoResponse cadastraLocatario(LocatarioNovoRequest locatarioNovo);
}