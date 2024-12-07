package br.com.divertech.divertfest.usuario.application.repository;

import br.com.divertech.divertfest.usuario.domain.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {
    void salva(Usuario usuario);
    Usuario buscaUsuario(String email);
    Usuario buscaUsuarioPorId(UUID idUsuario);
}