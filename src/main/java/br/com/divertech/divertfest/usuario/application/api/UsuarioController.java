package br.com.divertech.divertfest.usuario.application.api;

import br.com.divertech.divertfest.usuario.application.service.UsuarioApplicationService;
import br.com.divertech.divertfest.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@Validated
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {

    private final UsuarioService usuarioService;

    @Override
    public UsuarioCriadoResponse cadastraNovoLocatario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioController - cadastraNovoLocatario");
        UsuarioCriadoResponse usuarioCadastrado = usuarioService.cadastraLocatario(usuarioNovo);
        log.debug("[finish] UsuarioController - cadastraNovoLocatario");
        return usuarioCadastrado;
    }

    @Override
    public UsuarioCriadoResponse cadastraNovoLocador(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioController - cadastraNovoLocador");
        UsuarioCriadoResponse usuarioCadastrado = usuarioService.cadastraLocador(usuarioNovo);
        log.debug("[finish] UsuarioController - cadastraNovoLocador");
        return usuarioCadastrado;
    }

    @Override
    public UsuarioDetalhadoResponde getUsuario(String email) {
        log.info("[start] UsuarioController - getUsuario");
        UsuarioDetalhadoResponde usuario = usuarioService.buscaUsuarioPorEmail(email);
        log.debug("[finish] UsuarioController - getUsuario");
        return usuario;
    }

    @Override
    public UsuarioDetalhadoResponde getUsuarioById(UUID idUsuario) {
        log.info("[start] UsuarioController - getUsuarioById");
        UsuarioDetalhadoResponde usuario = usuarioService.buscaUsuarioPorId(idUsuario);
        log.debug("[finish] UsuarioController - getUsuarioById");
        return usuario;
    }

    @Override
    public void suspendeUsuario(UUID idUsuario) {
        log.info("[start] UsuarioController - suspendeUsuario");
        usuarioService.suspendeUsuario(idUsuario);
        log.debug("[finish] UsuarioController - suspendeUsuario");
    }

}