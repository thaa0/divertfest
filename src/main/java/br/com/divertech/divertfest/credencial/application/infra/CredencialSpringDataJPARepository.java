package br.com.divertech.divertfest.credencial.application.infra;

import br.com.divertech.divertfest.credencial.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CredencialSpringDataJPARepository extends JpaRepository<Credencial, UUID> {
}
