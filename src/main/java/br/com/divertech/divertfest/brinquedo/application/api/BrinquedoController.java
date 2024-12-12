package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.application.service.BrinquedoApplicationService;
import br.com.divertech.divertfest.brinquedo.application.service.BrinquedoService;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.service.LocadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class BrinquedoController implements BrinquedoAPI {
    private final BrinquedoService brinquedoService;
    private final LocadorService locadorService;

    @Override
    public BrinquedoResponse cadastraBrinquedo(BrinquedoRequest brinquedoRequest) {
        log.info("[start] BrinquedoController - cadastraBrinquedo");
        BrinquedoResponse brinquedoCadastrado = brinquedoService.cadastra(brinquedoRequest);
        log.debug("[finish] BrinquedoController - cadastraBrinquedo");
        return brinquedoCadastrado;
    }

    @Override
    public BrinquedoResponse buscaBrinquedoPorId(UUID idBrinquedo) {
        log.info("[start] BrinquedoController - buscaBrinquedoPorId");
        BrinquedoResponse brinquedo = brinquedoService.buscaBrinquedoPorId(idBrinquedo);
        log.debug("[finish] BrinquedoController - buscaBrinquedoPorId");
        return brinquedo;
    }


    @Override
    public void editaBrinquedo(UUID idBrinquedo, BrinquedoEditaRequest brinquedoEditaRequest) {
        log.info("[start] BrinquedoController - editaBrinquedo");
        brinquedoService.edita(idBrinquedo, brinquedoEditaRequest);
        log.debug("[finish] BrinquedoController - editaBrinquedo");
    }
}
