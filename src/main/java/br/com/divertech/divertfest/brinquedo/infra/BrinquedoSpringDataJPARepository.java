package br.com.divertech.divertfest.brinquedo.infra;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrinquedoSpringDataJPARepository extends JpaRepository<Brinquedo, UUID> {
}