package br.com.divertech.divertfest.locador.application.repository;

import br.com.divertech.divertfest.locador.domain.Locador;

import java.util.UUID;

public interface LocadorRepository {
    void salva(Locador locador);
    Locador buscaLocador(String email);
    Locador buscaLocadorPorId(UUID idLocador);
}
