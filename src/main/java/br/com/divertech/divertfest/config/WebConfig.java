package br.com.divertech.divertfest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Permite todas as rotas
                    .allowedOrigins("http://127.0.0.1:5500") // Permite todas as origens
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite todos os métodos
                    .allowedHeaders("*", "Authorization") // Permite todos os cabeçalhos
                    .allowCredentials(true); // ativa credenciais
        }
}
