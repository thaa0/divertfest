package br.com.divertech.divertfest.credencial.application.infra;

import br.com.divertech.divertfest.credencial.application.repository.CredencialRepository;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {

    private final CredencialSpringDataJPARepository credencialSpringDataJPARepository;
    @Override
    public void salva(Credencial novaCredencial) {
        log.info("[start] CredencialInfraRepository - salva");
        credencialSpringDataJPARepository.save(novaCredencial);
        log.debug("[finish] CredencialInfraRepository - salva");
    }

    @Override
    public Credencial buscaCredencialPorUsuario(String usuario) {
        log.info("[start] CredencialInfraRepository - buscaCredencialPorUsuario");
        Credencial credencial = credencialSpringDataJPARepository.findByUsuario(usuario)
                .orElseThrow(()-> new RuntimeException("Não encontrado!"));
        log.debug("[finish] CredencialInfraRepository - buscaCredencialPorUsuario");
        return credencial;
    }
}