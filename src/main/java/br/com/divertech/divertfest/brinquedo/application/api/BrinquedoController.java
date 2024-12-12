package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.application.service.BrinquedoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class BrinquedoController implements BrinquedoAPI {
    private final BrinquedoService brinquedoService;

    @Override
    public BrinquedoResponse cadastraBrinquedo(BrinquedoRequest brinquedoRequest) {
        log.info("[start] BrinquedoController - cadastraBrinquedo");
        BrinquedoResponse brinquedoCadastrado = brinquedoService.cadastra(brinquedoRequest);
        log.debug("[finish] BrinquedoController - cadastraBrinquedo");
        return brinquedoCadastrado;
    }
}
