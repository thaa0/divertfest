package br.com.divertech.divertfest.credencial.application.infra;

import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.UUID;

public interface CredencialSpringDataJPARepository extends JpaRepository<Credencial, UUID> {
    Optional<Credencial> findByUsuario(String usuario);
}
