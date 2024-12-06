package br.com.divertech.divertfest.credencial.application.service;

import br.com.divertech.divertfest.credencial.application.repository.CredencialRepository;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.credencial.domain.Role;
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
    public Credencial buscaCredencialPorUsuario(String usuario) {
        log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
        Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
        return credencial;
    }

    @Override
    public void criaNovaCredencialLocador(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] CredencialApplicationService - criaNovaCredencialLocador");
        Credencial novaCredencial = new Credencial(usuarioNovo.getEmail(), usuarioNovo.getSenha(), Role.LOCADOR);
        credencialRepository.salva(novaCredencial);
        log.debug("[finish] CredencialApplicationService - criaNovaCredencialLocador");

    }

    @Override
    public void criaNovaCredencialLocatario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] CredencialApplicationService - criaNovaCredencialLocatario");
        Credencial novaCredencial = new Credencial(usuarioNovo.getEmail(), usuarioNovo.getSenha(),Role.LOCATARIO);
        credencialRepository.salva(novaCredencial);
        log.debug("[finish] CredencialApplicationService - criaNovaCredencialLocatario");
    }
}