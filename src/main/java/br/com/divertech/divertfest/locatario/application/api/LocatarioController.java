package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.locatario.application.service.LocatarioService;
import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.service.UsuarioApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class LocatarioController implements LocatarioAPI {

    private final LocatarioService locatarioService;

    @Override
    public LocatarioCriadoResponse cadastraNovoLocatario(LocatarioNovoRequest locatarioNovo) {
        log.info("[start] UsuarioController - cadastraNovoLocatario");
        LocatarioCriadoResponse usuarioCadastrado = locatarioService.cadastraLocatario(locatarioNovo);
        log.debug("[finish] UsuarioController - cadastraNovoLocatario");
        return usuarioCadastrado;
    }
}
