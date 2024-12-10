package br.com.divertech.divertfest.brinquedo.application.service;

import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoResponse;
import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BrinquedoApplicationService implements BrinquedoService {
    private final LocadorRepository locadorRepository;
    private final BrinquedoRepository brinquedoRepository;

    @Override
    public BrinquedoResponse cadastra(BrinquedoRequest brinquedoRequest) {
        log.info("[start] BrinquedoApplicationService - cadastra");
        log.info("ID do dono do brinquedo: {}", brinquedoRequest.getDonoBrinquedo());
        Locador locador = locadorRepository.buscaLocadorPorId(brinquedoRequest.getDonoBrinquedo());
        Brinquedo brinquedo = new Brinquedo(brinquedoRequest, locador);
        brinquedoRepository.salva(brinquedo);
        log.debug("[finish] BrinquedoApplicationService - cadastra");
        return new BrinquedoResponse(brinquedo);
    }
}
