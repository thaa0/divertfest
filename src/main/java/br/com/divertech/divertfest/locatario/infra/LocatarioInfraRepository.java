package br.com.divertech.divertfest.locatario.infra;

import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Log4j2
@Repository
public class LocatarioInfraRepository implements LocatarioRepository {
    private final LocatarioSpringDataJPARepository locatarioSpringDataJPARepository;

    @Override
    public void salva(Locatario locatarioNovo) {
        log.info("[start] LocatarioInfraRepository - salva");
        locatarioSpringDataJPARepository.save(locatarioNovo);
        log.debug("[finish] LocatarioInfraRepository - salva");
    }
}
