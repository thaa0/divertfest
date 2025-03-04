package br.com.divertech.divertfest.brinquedo.application.repository;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.locador.domain.Locador;

import java.util.List;
import java.util.UUID;

public interface BrinquedoRepository {
    void salva(Brinquedo brinquedo);
    Brinquedo buscaBrinquedoPorId(UUID idBrinquedo);
    void apaga(Brinquedo brinquedo);
    List<Brinquedo> listaBrinquedos();
    List<Brinquedo> buscaBrinquedoPorNome(String nome);
    List<Brinquedo> buscaBrinquedoDoLocador(Locador locador);
}
