package br.com.divertech.divertfest.locador.infra;

import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class LocadorInfraRepository implements LocadorRepository {
    private final LocadorSpringDataJPARepository locadorSpringDataJPARepository;

    @Override
    public void salva(Locador locador) {
        log.info("[start] LocadorInfraRepository - salva");
        locadorSpringDataJPARepository.save(locador);
        log.debug("[finish] LocadorInfraRepository - salva");
    }
}