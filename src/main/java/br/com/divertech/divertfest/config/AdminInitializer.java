package br.com.divertech.divertfest.config;

import br.com.divertech.divertfest.credencial.application.infra.CredencialSpringDataJPARepository;
import br.com.divertech.divertfest.credencial.application.repository.CredencialRepository;
import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.credencial.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AdminInitializer {

    private final CredencialSpringDataJPARepository credencialRepository;

    @Bean
     public void initializeAdmin() {
         if (credencialRepository.findByUsuario("admin@gmail.com").isEmpty()) {
             Credencial admin = new Credencial("admin@gmail.com", "admin123", Role.ADMIN);
             credencialRepository.save(admin);
         }
     }
}