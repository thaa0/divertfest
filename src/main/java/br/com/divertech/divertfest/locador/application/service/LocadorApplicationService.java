package br.com.divertech.divertfest.locador.application.service;

import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.api.LocadorCriadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorDetalhadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorEditaRequest;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocadorApplicationService implements LocadorService {

    private final TokenService tokenService;
    private final LocadorRepository locadorRepository;
    private final CredencialService credencialService;

    @Override
    public LocadorCriadoResponse cadastraLocador(LocadorNovoRequest locadorNovo) {
        log.info("[start] LocadorApplicationService - cadastraLocador");
        credencialService.criaNovaCredencialLocador(locadorNovo);
        Locador locador = new Locador(locadorNovo);
        locadorRepository.salva(locador);
        log.debug("[finish] LocadorApplicationService - cadastraLocador");
        return new LocadorCriadoResponse(locador);
    }

    @Override
    public LocadorDetalhadoResponse buscaLocadorPorEmail(String email) {
        log.info("[start] LocadorApplicationService - buscaLocadorPorEmail");
        Locador locador = locadorRepository.buscaLocador(email);
        log.debug("[finish] LocadorApplicationService - buscaLocadorPorEmail");
        return new LocadorDetalhadoResponse(locador);
    }

    @Override
    public LocadorDetalhadoResponse buscaLocadorPorId(UUID idLocador) {
        log.info("[start] LocadorApplicationService - buscaLocadorPorId");
        Locador locador = locadorRepository.buscaLocadorPorId(idLocador);
        log.debug("[finish] LocadorApplicationService - buscaLocadorPorId");
        return new LocadorDetalhadoResponse(locador);
    }

    @Override
    public void ativaLocador(UUID idLocador) {
        log.info("[start] LocadorApplicationService - ativaLocador");
        Locador locador = locadorRepository.buscaLocadorPorId(idLocador);
        locador.checaLocadorAtivo();
        locador.ativa();
        locadorRepository.salva(locador);
        log.debug("[finish] LocadorApplicationService - ativaLocador");
    }

    @Override
    public void suspendeLocador(UUID idLocador) {
        log.info("[start] LocadorApplicationService - suspendeLocador");
        Locador locador = locadorRepository.buscaLocadorPorId(idLocador);
        locador.checaLocadorSuspenso();
        locador.suspende();
        locadorRepository.salva(locador);
        log.debug("[finish] LocadorApplicationService - suspendeLocador");
    }

    @Override
    public void checaLocadorSuspenso(UUID idLocador) {
        log.info("[start] LocadorApplicationService - checaLocadorSuspenso");
        Locador locador = locadorRepository.buscaLocadorPorId(idLocador);
        locador.checaLocadorSuspenso();
        log.debug("[finish] LocadorApplicationService - checaLocadorSuspenso");
    }

    @Override
    public void editaLocador(String token, LocadorEditaRequest locadorAtualizado) {
        log.info("[start] LocadorApplicationService - editaLocador");
        String email = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        Locador locador = locadorRepository.buscaLocador(email);
        locador.edita(locadorAtualizado);
        locadorRepository.salva(locador);
        log.debug("[finish] LocadorApplicationService - editaLocador");
    }

}