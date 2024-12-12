package br.com.divertech.divertfest.brinquedo.infra;

import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class BrinquedoInfraRepository implements BrinquedoRepository {
    private final BrinquedoSpringDataJPARepository brinquedoSpringDataJPARepository;

    @Override
    public void salva(Brinquedo brinquedo) {
        log.info("[start] BrinquedoInfraRepository - salva");
        brinquedoSpringDataJPARepository.save(brinquedo);
        log.debug("[finish] BrinquedoInfraRepository - salva");
    }

    @Override
    public Brinquedo buscaBrinquedoPorId(String idBrinquedo) {
        log.info("[start] BrinquedoInfraRepository - buscaBrinquedoPorId");
        Brinquedo brinquedo = brinquedoSpringDataJPARepository.findById(UUID.fromString(idBrinquedo)).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
        log.debug("[finish] BrinquedoInfraRepository - buscaBrinquedoPorId");
        return brinquedo;
    }
}
