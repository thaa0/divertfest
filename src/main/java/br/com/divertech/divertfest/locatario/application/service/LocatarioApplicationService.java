package br.com.divertech.divertfest.locatario.application.service;

import br.com.divertech.divertfest.credencial.application.infra.CredencialInfraRepository;
import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.locatario.application.api.LocatarioCriadoResponse;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
