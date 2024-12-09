package br.com.divertech.divertfest.locador.application.service;

import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.locador.application.api.LocadorCriadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorDetalhadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocadorApplicationService implements LocadorService {

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


}