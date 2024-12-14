package br.com.divertech.divertfest.brinquedo.application.repository;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;

import java.util.UUID;

public interface BrinquedoRepository {
    void salva(Brinquedo brinquedo);
    Brinquedo buscaBrinquedoPorId(UUID idBrinquedo);
    void apaga(Brinquedo brinquedo);
}
