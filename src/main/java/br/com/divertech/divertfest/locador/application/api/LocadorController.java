package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.locador.application.service.LocadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LocadorController implements LocadorAPI {

    private final LocadorService locadorService;

    @Override
    public LocadorCriadoResponse cadastraNovoLocador(LocadorNovoRequest locadorNovo) {
        log.info("[start] LocadorController - cadastraNovoLocador");
        LocadorCriadoResponse locadorCadastrado = locadorService.cadastraLocador(locadorNovo);
        log.debug("[finish] LocadorController - cadastraNovoLocador");
        return locadorCadastrado;
    }

    @Override
    public LocadorDetalhadoResponse getLocador(String email) {
        log.info("[start] LocadorController - getLocador");
        LocadorDetalhadoResponse locador = locadorService.buscaLocadorPorEmail(email);
        log.debug("[finish] LocadorController - getLocador");
        return locador;
    }

    @Override
    public LocadorDetalhadoResponse getLocadorById(UUID idLocador) {
        log.info("[start] LocadorController - getLocadorById");
        LocadorDetalhadoResponse locador = locadorService.buscaLocadorPorId(idLocador);
        log.debug("[finish] LocadorController - getLocadorById");
        return locador;
    }

    @Override
    public void ativaLocador(UUID idLocador) {
        log.info("[start] LocadorController - ativaLocador");
        locadorService.ativaLocador(idLocador);
        log.debug("[finish] LocadorController - ativaLocador");
    }

    @Override
    public void suspendeLocador(UUID idLocador) {
        log.info("[start] LocadorController - suspendeLocador");
        locadorService.suspendeLocador(idLocador);
        log.debug("[finish] LocadorController - suspendeLocador");
    }
}
