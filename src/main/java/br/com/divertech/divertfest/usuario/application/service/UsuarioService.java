package br.com.divertech.divertfest.usuario.application.service;

import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;

public interface UsuarioService {
    UsuarioCriadoResponse cadastraLocador(UsuarioNovoRequest usuarioNovo);
    UsuarioCriadoResponse cadastraLocatario(UsuarioNovoRequest usuarioNovo);
}
