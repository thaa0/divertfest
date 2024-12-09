package br.com.divertech.divertfest.locatario.infra;

import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Locatario buscaLocatarioPorId(UUID idLocatario) {
        log.info("[start] LocatarioInfraRepository - buscaLocatarioPorId");
        Locatario locatario = locatarioSpringDataJPARepository.findById(idLocatario)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Locatário não encontrado!"));
        log.debug("[finish] LocatarioInfraRepository - buscaLocatarioPorId");
        return locatario;
    }

    @Override
    public Locatario buscaLocatario(String email) {
        log.info("[start] LocatarioInfraRepository - buscaLocatario");
        Locatario locatario = locatarioSpringDataJPARepository.findByEmail(email)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Locatário não encontrado!"));
        log.debug("[finish] LocatarioInfraRepository - buscaLocatario");
        return locatario;
    }
}
