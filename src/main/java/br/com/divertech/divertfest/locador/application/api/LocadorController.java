package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.locador.application.service.LocadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LocadorController implements LocadorAPI {

    private final LocadorService locadorService;

    @Override
    public LocadorCriadoResponse cadastraNovoLocador(LocadorNovoRequest locadorNovo) {
        log.info("[start] UsuarioController - cadastraNovoLocador");
        LocadorCriadoResponse locadorCadastrado = locadorService.cadastraLocador(locadorNovo);
        log.debug("[finish] UsuarioController - cadastraNovoLocador");
        return locadorCadastrado;
    }
}
