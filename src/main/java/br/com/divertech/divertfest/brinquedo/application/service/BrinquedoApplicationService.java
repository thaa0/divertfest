package br.com.divertech.divertfest.brinquedo.application.service;

import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoEditaRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoResponse;
import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.application.service.LocadorService;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class BrinquedoApplicationService implements BrinquedoService {
    private final LocadorRepository locadorRepository;
    private final BrinquedoRepository brinquedoRepository;
    private final LocadorService locadorService;

    @Override
    public BrinquedoResponse cadastra(String emailLocador, BrinquedoRequest brinquedoRequest) {
        log.info("[start] BrinquedoApplicationService - cadastra");
        Locador locador = locadorRepository.buscaLocador(emailLocador);
        Brinquedo brinquedo = new Brinquedo(brinquedoRequest, locador);
        brinquedoRepository.salva(brinquedo);
        log.debug("[finish] BrinquedoApplicationService - cadastra");
        return new BrinquedoResponse(brinquedo);
    }

    @Override
    public void edita(String emailLocador,UUID idBrinquedo, BrinquedoEditaRequest brinquedoRequest) {
        log.info("[start] BrinquedoApplicationService - edita");
        Brinquedo brinquedo = detalhaBrinquedo(emailLocador, idBrinquedo);
        locadorService.checaLocadorSuspenso(brinquedo.getDonoBrinquedo().getIdUsuario());
        brinquedo.edita(brinquedoRequest);
        brinquedoRepository.salva(brinquedo);
        log.debug("[finish] BrinquedoApplicationService - edita");
    }

    private Brinquedo detalhaBrinquedo(String emailLocador, UUID idBrinquedo) {
        log.info("[start] BrinquedoApplicationService - detalhaBrinquedo");
        Locador locador= locadorRepository.buscaLocador(emailLocador);
        Brinquedo brinquedo = brinquedoRepository.buscaBrinquedoPorId(idBrinquedo);
        brinquedo.pertenceAoLocador(locador);
        log.debug("[finish] BrinquedoApplicationService - detalhaBrinquedo");
        return brinquedo;
    }

    @Override
    public BrinquedoResponse buscaBrinquedoPorId(UUID idBrinquedo) {
        log.info("[start] BrinquedoApplicationService - buscaBrinquedoPorId");
        Brinquedo brinquedo = brinquedoRepository.buscaBrinquedoPorId(idBrinquedo);
        log.debug("[finish] BrinquedoApplicationService - buscaBrinquedoPorId");
        return new BrinquedoResponse(brinquedo);
    }

    @Override
    public void apaga(String emailLocador, UUID idBrinquedo) {
        log.info("[start] BrinquedoApplicationService - apaga");
        Brinquedo brinquedo = detalhaBrinquedo(emailLocador, idBrinquedo);
        locadorService.checaLocadorSuspenso(brinquedo.getDonoBrinquedo().getIdUsuario());
        brinquedoRepository.apaga(brinquedo);
        log.debug("[finish] BrinquedoApplicationService - apaga");
    }

    @Override
    public List<BrinquedoResponse> listaBrinquedos() {
        log.info("[start] BrinquedoApplicationService - listaBrinquedos");
        List<Brinquedo> brinquedos = brinquedoRepository.listaBrinquedos();
        log.debug("[finish] BrinquedoApplicationService - listaBrinquedos");
        return BrinquedoResponse.converte(brinquedos);
    }

}