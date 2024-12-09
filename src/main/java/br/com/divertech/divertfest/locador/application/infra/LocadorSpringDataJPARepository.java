package br.com.divertech.divertfest.locador.application.infra;

import br.com.divertech.divertfest.locador.domain.Locador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocadorSpringDataJPARepository extends JpaRepository<Locador, UUID> {
}
