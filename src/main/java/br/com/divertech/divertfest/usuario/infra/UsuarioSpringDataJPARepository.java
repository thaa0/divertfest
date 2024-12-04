package br.com.divertech.divertfest.usuario.infra;

import br.com.divertech.divertfest.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioSpringDataJPARepository extends JpaRepository<Usuario, UUID> {
}