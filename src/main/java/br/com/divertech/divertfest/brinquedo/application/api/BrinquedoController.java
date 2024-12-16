package br.com.divertech.divertfest.brinquedo.application.api;

import br.com.divertech.divertfest.brinquedo.application.service.BrinquedoApplicationService;
import br.com.divertech.divertfest.brinquedo.application.service.BrinquedoService;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.service.LocadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class BrinquedoController implements BrinquedoAPI {
    private final BrinquedoService brinquedoService;
    private final LocadorService locadorService;
    private final TokenService tokenService;

    @Override
    public BrinquedoResponse cadastraBrinquedo(String token, BrinquedoRequest brinquedoRequest) {
        log.info("[start] BrinquedoController - cadastraBrinquedo");
        String emailLocador = getUsuarioByToken(token);
        BrinquedoResponse brinquedoCadastrado = brinquedoService.cadastra(emailLocador, brinquedoRequest);
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
    public void editaBrinquedo(String token, UUID idBrinquedo, BrinquedoEditaRequest brinquedoEditaRequest) {
        log.info("[start] BrinquedoController - editaBrinquedo");
        String emailLocador = getUsuarioByToken(token);
        brinquedoService.edita(emailLocador, idBrinquedo, brinquedoEditaRequest);
        log.debug("[finish] BrinquedoController - editaBrinquedo");
    }

    @Override
    public void apagaBrinquedo(String token, UUID idBrinquedo) {
        log.info("[start] BrinquedoController - apagaBrinquedo");
        String emailLocador = getUsuarioByToken(token);
        brinquedoService.apaga(emailLocador, idBrinquedo);
        log.debug("[finish] BrinquedoController - apagaBrinquedo");
    }

    @Override
    public List<BrinquedoResponse> listaBrinquedos() {
        log.info("[start] BrinquedoController - listaBrinquedos");
        List<BrinquedoResponse> brinquedos = brinquedoService.listaBrinquedos();
        log.debug("[finish] BrinquedoController - listaBrinquedos");
        return brinquedos;
    }

    @Override
    public List<BrinquedoResponse> buscaBrinquedoPorNome(String nome) {
        log.info("[start] BrinquedoController - buscaBrinquedoPorNome");
        List<BrinquedoResponse> brinquedos = brinquedoService.buscaBrinquedoPorNome(nome);
        log.debug("[finish] BrinquedoController - buscaBrinquedoPorNome");
        return brinquedos;
    }

    private String getUsuarioByToken(String token) {
        log.debug("[token] {}", token);
        String locador = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[locador] {}", locador);
        return locador;
    }
}
