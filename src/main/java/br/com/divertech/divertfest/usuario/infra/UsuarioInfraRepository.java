package br.com.divertech.divertfest.usuario.infra;

import br.com.divertech.divertfest.usuario.application.repository.UsuarioRepository;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepository usuarioJPAInfraRepository;

    @Override
    public void salva(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - salva");
        usuarioJPAInfraRepository.salva(usuario);
        log.debug("[finish] UsuarioInfraRepository - salva");
    }
}
