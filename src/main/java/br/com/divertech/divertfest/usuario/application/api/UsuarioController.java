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
    public UsuarioCriadoResponse cadastraNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioController - cadastraNovoUsuario");
        UsuarioCriadoResponse usuarioCadastrado = usuarioService.cadastraUsuario(usuarioNovo);
        log.debug("[finish] UsuarioController - cadastraNovoUsuario");
        return usuarioCadastrado;
    }
}