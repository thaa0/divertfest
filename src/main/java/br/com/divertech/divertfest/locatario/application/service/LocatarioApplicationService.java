package br.com.divertech.divertfest.locatario.application.service;

import br.com.divertech.divertfest.credencial.application.infra.CredencialInfraRepository;
import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.locatario.application.api.LocatarioCriadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioDetalhadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocatarioApplicationService implements LocatarioService {
    private final LocatarioRepository locatarioRepository;
    private final CredencialService credencialService;

    @Override
    public LocatarioCriadoResponse cadastraLocatario(LocatarioNovoRequest locatarioNovo) {
        log.info("[start] LocatarioApplicationService - cadastraLocatario");
        credencialService.criaNovaCredencialLocatario(locatarioNovo);
        Locatario locatario = new Locatario(locatarioNovo);
        locatarioRepository.salva(locatario);
        log.debug("[finish] LocatarioApplicationService - cadastraLocatario");
        return new LocatarioCriadoResponse(locatario);
    }

    @Override
    public LocatarioDetalhadoResponse buscaLocatario(String email) {
        log.info("[start] LocatarioApplicationService - buscaLocatarioPorEmail");
        Locatario locatario = locatarioRepository.buscaLocatario(email);
        log.debug("[finish] LocatarioApplicationService - buscaLocatarioPorEmail");
        return new LocatarioDetalhadoResponse(locatario);
    }

    @Override
    public LocatarioDetalhadoResponse buscaLocatarioPorId(UUID idLocatario) {
        log.info("[start] LocatarioApplicationService - buscaLocatarioPorId");
        Locatario locatario = locatarioRepository.buscaLocatarioPorId(idLocatario);
        log.debug("[finish] LocatarioApplicationService - buscaLocatarioPorId");
        return new LocatarioDetalhadoResponse(locatario);
    }

    @Override
    public void suspendeLocatario(UUID idLocatario) {
        log.info("[start] LocatarioApplicationService - suspendeLocatario");
        Locatario locatario = locatarioRepository.buscaLocatarioPorId(idLocatario);
        locatario.checaLocatarioSuspenso();
        locatario.suspende();
        locatarioRepository.salva(locatario);
        log.debug("[finish] LocatarioApplicationService - suspendeLocatario");
    }

    @Override
    public void ativaLocatario(UUID idLocatario) {
        log.info("[start] LocatarioApplicationService - ativaLocatario");
        Locatario locatario = locatarioRepository.buscaLocatarioPorId(idLocatario);
        locatario.checaLocatarioAtivo();
        locatario.ativa();
        locatarioRepository.salva(locatario);
        log.debug("[finish] LocatarioApplicationService - ativaLocatario");
    }

}
