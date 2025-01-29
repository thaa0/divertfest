package br.com.divertech.divertfest.config;

import br.com.divertech.divertfest.credencial.application.infra.CredencialSpringDataJPARepository;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.credencial.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RequiredArgsConstructor

public class AdminInitializer {
    private final CredencialSpringDataJPARepository credencialRepository;
    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

     @EventListener(ApplicationReadyEvent.class)
     public void initializeAdmin() {
         if (credencialRepository.findByUsuario(adminEmail).isEmpty()) {
             Credencial admin = new Credencial(adminEmail, adminPassword, Role.ADMIN);
             credencialRepository.save(admin);
         }
     }
}

