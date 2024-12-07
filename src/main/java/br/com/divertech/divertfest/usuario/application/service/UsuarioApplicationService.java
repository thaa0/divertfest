package br.com.divertech.divertfest.usuario.application.service;

import br.com.divertech.divertfest.credencial.application.service.CredencialService;
import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioDetalhadoResponde;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import br.com.divertech.divertfest.usuario.application.repository.UsuarioRepository;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final CredencialService credencialService;


    @Override
    public UsuarioCriadoResponse cadastraLocador(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioApplicationService - cadastraLocador");
        credencialService.criaNovaCredencialLocador(usuarioNovo);
        Usuario usuario = new Usuario(usuarioNovo);
        usuarioRepository.salva(usuario);
        log.debug("[finish] UsuarioApplicationService - cadastraLocador");
        return new UsuarioCriadoResponse(usuario);
    }

    @Override
    public UsuarioCriadoResponse cadastraLocatario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioApplicationService - cadastraLocatario");
        credencialService.criaNovaCredencialLocatario(usuarioNovo);
        Usuario usuario = new Usuario(usuarioNovo);
        usuarioRepository.salva(usuario);
        log.debug("[finish] UsuarioApplicationService - cadastraLocatario");
        return new UsuarioCriadoResponse(usuario);
    }

    @Override
    public UsuarioDetalhadoResponde buscaUsuarioPorEmail(String email) {
        log.info("[start] UsuarioApplicationService - buscaUsuarioPorEmail");
        Usuario usuario = usuarioRepository.buscaUsuario(email);
        log.debug("[finish] UsuarioApplicationService - buscaUsuarioPorEmail");
        return new UsuarioDetalhadoResponde(usuario);
    }

    @Override
    public UsuarioDetalhadoResponde buscaUsuarioPorId(UUID idUsuario) {
        log.info("[start] UsuarioApplicationService - buscaUsuarioPorId");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        log.debug("[finish] UsuarioApplicationService - buscaUsuarioPorId");
        return new UsuarioDetalhadoResponde(usuario);
    }

    @Override
    public void suspendeUsuario(UUID idUsuario) {
        log.info("[start] UsuarioApplicationService - suspendeUsuario");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        usuario.validaUsuarioJaSuspenso();
        usuario.alteraStatusSuspenso();
        usuarioRepository.salva(usuario);
        log.debug("[finish] UsuarioApplicationService - suspendeUsuario");
    }

    @Override
    public void ativaUsuario(UUID idUsuario) {
        log.info("[start] UsuarioApplicationService - ativaUsuario");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        usuario.validaUsuarioJaAtivo();
        usuario.alteraStatusAtivo();
        usuarioRepository.salva(usuario);
        log.debug("[finish] UsuarioApplicationService - ativaUsuario");
    }
}