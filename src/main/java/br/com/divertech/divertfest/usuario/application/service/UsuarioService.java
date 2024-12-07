package br.com.divertech.divertfest.usuario.application.service;

import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioDetalhadoResponde;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;

import java.util.UUID;

public interface UsuarioService {
    UsuarioCriadoResponse cadastraLocador(UsuarioNovoRequest usuarioNovo);
    UsuarioCriadoResponse cadastraLocatario(UsuarioNovoRequest usuarioNovo);
    UsuarioDetalhadoResponde buscaUsuarioPorEmail(String email);
    UsuarioDetalhadoResponde buscaUsuarioPorId(UUID idUsuario);
}
