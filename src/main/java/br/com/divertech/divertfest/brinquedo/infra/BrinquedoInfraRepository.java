package br.com.divertech.divertfest.brinquedo.infra;

import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.brinquedo.domain.StatusBrinquedo;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public Brinquedo buscaBrinquedoPorId(UUID idBrinquedo) {
        log.info("[start] BrinquedoInfraRepository - buscaBrinquedoPorId");
        Brinquedo brinquedo = brinquedoSpringDataJPARepository.findById(idBrinquedo).orElseThrow(() -> APIException.build(HttpStatus.CONFLICT, "Brinquedo não encontrado"));
        log.debug("[finish] BrinquedoInfraRepository - buscaBrinquedoPorId");
        return brinquedo;
    }

    @Override
    public void apaga(Brinquedo brinquedo) {
        log.info("[start] BrinquedoInfraRepository - apaga");
        brinquedoSpringDataJPARepository.delete(brinquedo);
        log.debug("[finish] BrinquedoInfraRepository - apaga");
    }

    @Override
    public List<Brinquedo> listaBrinquedos() {
        log.info("[start] BrinquedoInfraRepository - listaBrinquedos");
        List<Brinquedo> brinquedos = brinquedoSpringDataJPARepository.findAllByStatus(StatusBrinquedo.DISPONIVEL);
        log.debug("[finish] BrinquedoInfraRepository - listaBrinquedos");
        return brinquedos;
    }

    @Override
    public List<Brinquedo> buscaBrinquedoPorNome(String nome) {
        log.info("[start] BrinquedoInfraRepository - buscaBrinquedoPorNome");
        List<Brinquedo> brinquedos = brinquedoSpringDataJPARepository.findAllByNomeContainingIgnoreCaseAndStatus(nome, StatusBrinquedo.DISPONIVEL);
        log.debug("[finish] BrinquedoInfraRepository - buscaBrinquedoPorNome");
        return brinquedos;
    }

    @Override
    public List<Brinquedo> buscaBrinquedoDoLocador(Locador locador) {
        log.info("[start] BrinquedoInfraRepository - buscaBrinquedoDoLocador");
        List<Brinquedo> brinquedos = brinquedoSpringDataJPARepository.findAllByDonoBrinquedo(locador);
        log.debug("[finish] BrinquedoInfraRepository - buscaBrinquedoDoLocador");
        return brinquedos;
    }
}
