package br.com.divertech.divertfest.brinquedo.infra;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.brinquedo.domain.StatusBrinquedo;
import br.com.divertech.divertfest.locador.domain.Locador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BrinquedoSpringDataJPARepository extends JpaRepository<Brinquedo, UUID> {
    List<Brinquedo> findAllByStatus(StatusBrinquedo status);
    List<Brinquedo> findAllByNomeContainingIgnoreCaseAndStatus(String nome, StatusBrinquedo statusBrinquedo);
    List<Brinquedo> findAllByDonoBrinquedo(Locador locador);
}