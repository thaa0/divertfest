package br.com.divertech.divertfest.locatario.infra;

import br.com.divertech.divertfest.locatario.domain.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocatarioSpringDataJPARepository extends JpaRepository<Locatario, UUID> {
}
