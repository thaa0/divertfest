package br.com.divertech.divertfest.usuario.application.repository;

import br.com.divertech.divertfest.usuario.domain.Usuario;

public interface UsuarioRepository {
    void salva(Usuario usuario);
}