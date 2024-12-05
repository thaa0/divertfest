package br.com.divertech.divertfest.credencial.application.service;

import br.com.divertech.divertfest.credencial.application.repository.CredencialRepository;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CredencialApplicationService implements CredencialService {
    private final CredencialRepository credencialRepository;

    @Override
    public void criaNovaCredencial(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] CredencialApplicationService - criaNovaCredencial");
        Credencial novaCredencial = new Credencial(usuarioNovo.getEmail(), usuarioNovo.getSenha(), usuarioNovo.getRole());
        credencialRepository.salva(novaCredencial);
        log.debug("[finish] CredencialApplicationService - criaNovaCredencial");
    }

    @Override
    public Credencial buscaCredencialPorUsuario(String usuario) {
        log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
        Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
        return credencial;
    }
}
