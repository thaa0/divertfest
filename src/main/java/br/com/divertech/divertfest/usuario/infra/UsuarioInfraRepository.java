package br.com.divertech.divertfest.usuario.infra;

import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.usuario.application.repository.UsuarioRepository;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepository usuarioJPAInfraRepository;

    @Override
    public void salva(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - salva");
        usuarioJPAInfraRepository.save(usuario);
        log.debug("[finish] UsuarioInfraRepository - salva");
    }

    @Override
    public Usuario buscaUsuario(String email) {
        log.info("[start] UsuarioInfraRepository - buscaUsuario");
        Usuario usuario = usuarioJPAInfraRepository.findByEmail(email)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Usuario não existe"));
        log.debug("[finish] UsuarioInfraRepository - buscaUsuario");
        return usuario;
    }

    @Override
    public Usuario buscaUsuarioPorId(UUID idUsuario) {
        log.info("[start] UsuarioInfraRepository - buscaUsuarioPorId");
        Usuario usuario = usuarioJPAInfraRepository.findById(idUsuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Usuario não existe"));
        log.debug("[finish] UsuarioInfraRepository - buscaUsuarioPorId");
        return usuario;
    }
}
