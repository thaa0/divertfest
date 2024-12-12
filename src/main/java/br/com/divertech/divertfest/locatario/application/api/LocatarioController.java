package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.locatario.application.service.LocatarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class LocatarioController implements LocatarioAPI {

    private final LocatarioService locatarioService;

    @Override
    public LocatarioCriadoResponse cadastraNovoLocatario(LocatarioNovoRequest locatarioNovo) {
        log.info("[start] LocatarioController - cadastraNovoLocatario");
        LocatarioCriadoResponse usuarioCadastrado = locatarioService.cadastraLocatario(locatarioNovo);
        log.debug("[finish] LocatarioController - cadastraNovoLocatario");
        return usuarioCadastrado;
    }

    @Override
    public LocatarioDetalhadoResponse getLocatario(String email) {
        log.info("[start] LocatarioController - getLocatario");
        LocatarioDetalhadoResponse locatario = locatarioService.buscaLocatario(email);
        log.debug("[finish] LocatarioController - getLocatario");
        return locatario;
    }

    @Override
    public LocatarioDetalhadoResponse getLocatarioById(UUID idLocatario) {
        log.info("[start] LocatarioController - getLocatarioById");
        LocatarioDetalhadoResponse locatario = locatarioService.buscaLocatarioPorId(idLocatario);
        log.debug("[finish] LocatarioController - getLocatarioById");
        return locatario;
    }

    @Override
    public void suspendeLocatario(UUID idLocatario) {
        log.info("[start] LocatarioController - suspendeLocatario");
        locatarioService.suspendeLocatario(idLocatario);
        log.debug("[finish] LocatarioController - suspendeLocatario");
    }

    @Override
    public void ativaLocatario(UUID idLocatario) {
        log.info("[start] LocatarioController - ativaLocatario");
        locatarioService.ativaLocatario(idLocatario);
        log.debug("[finish] LocatarioController - ativaLocatario");
    }
}
