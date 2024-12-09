package br.com.divertech.divertfest.locador.infra;

import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Locador buscaLocador(String email) {
        log.info("[start] LocadorInfraRepository - buscaLocador");
        Locador locador = locadorSpringDataJPARepository.findByEmail(email)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.debug("[finish] LocadorInfraRepository - buscaLocador");
        return locador;
    }

    @Override
    public Locador buscaLocadorPorId(UUID idLocador) {
        log.info("[start] LocadorInfraRepository - buscaLocadorPorId");
        Locador locador = locadorSpringDataJPARepository.findById(idLocador)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.debug("[finish] LocadorInfraRepository - buscaLocadorPorId");
        return locador;
    }
}