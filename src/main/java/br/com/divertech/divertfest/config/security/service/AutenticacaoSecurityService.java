package br.com.divertech.divertfest.config.security.service;

import br.com.divertech.divertfest.credencial.application.repository.CredencialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        log.info("[inicio] AutenticacaoSecurityService - buscando credencial pelo usuario");
        var credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] AutenticacaoSecurityService - buscando credencial pelo usuario");
        return Optional.ofNullable(credencial).orElseThrow(() -> new RuntimeException("Não existe credencial para o Usuario informado!"));
    }
}