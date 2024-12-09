package br.com.divertech.divertfest.locador.application.service;

import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.locador.application.api.LocadorCriadoResponse;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocadorApplicationService implements LocadorService {

    private final LocadorRepository locadorRepostory;
    private final CredencialService credencialService;
    @Override
    public LocadorCriadoResponse cadastraLocador(LocadorNovoRequest locadorNovo) {
        log.info("[start] UsuarioApplicationService - cadastraLocador");
        credencialService.criaNovaCredencialLocador(usuarioNovo);
        Locador locador = new Locador(locadorNovo);
        locadorRepostory.salva(locador);
        log.debug("[finish] UsuarioApplicationService - cadastraLocador");
        return new LocadorCriadoResponse(locador);
    }
}
