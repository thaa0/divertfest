package br.com.divertech.divertfest.usuario.application.service;

import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import br.com.divertech.divertfest.usuario.application.repository.UsuarioRepository;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioCriadoResponse cadastraUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] usuarioApplicationService - cadastraUsuario");
       // credencialService.criaNovaCredencial(usuarioNovo);
        Usuario usuario = new Usuario(usuarioNovo);
        usuarioRepository.salva(usuario);
        log.debug("[finish] usuarioApplicationService - cadastraUsuario");
        return new UsuarioCriadoResponse(usuario);
    }
}
