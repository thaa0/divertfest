package br.com.divertech.divertfest.locatario.application.repository;

import br.com.divertech.divertfest.locatario.domain.Locatario;

import java.util.UUID;

public interface LocatarioRepository {
    void salva(Locatario locatarioNovo);
    Locatario buscaLocatarioPorId(UUID idLocatario);
    Locatario buscaLocatario(String email);
}
