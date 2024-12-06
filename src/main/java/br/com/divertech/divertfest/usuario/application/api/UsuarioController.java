package br.com.divertech.divertfest.usuario.application.api;

import br.com.divertech.divertfest.usuario.application.service.UsuarioApplicationService;
import br.com.divertech.divertfest.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

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
}