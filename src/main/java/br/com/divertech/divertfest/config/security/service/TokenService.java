package br.com.divertech.divertfest.config.security.service;

import br.com.divertech.divertfest.credencial.domain.Credencial;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@Log4j2
public class TokenService {
   // @Value("${divertfest.jwt.expiracao}")
    private String expiracao;
   // @Value("${divertfest.jwt.chave}")
    private String chave;

    public String gerarToken(Authentication authentication) {
        return gerarToken((Credencial) authentication.getPrincipal());
    }

    public String gerarToken(Credencial credencial) {
        log.info("[inicio] TokenService - criação de token");
        String token = Jwts.builder()
                .setIssuer("API do Produdoro")
                .setSubject(credencial.getUsuario())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now()
                        .plusMinutes(Long.parseLong(expiracao))
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .signWith(SignatureAlgorithm.HS256, chave)
                .compact();
        log.info("[finaliza] TokenService - criação de token");
        return token;
    }

    public Optional<String> getUsuario(String token) {
        try {
            log.info("[inicio] TokenService - extração do ID do Token");
            var claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
            return Optional.of(claims.getSubject());
        } catch (SignatureException ex) {
            return Optional.empty();
        } catch (ExpiredJwtException ex) {
            var claims = ex.getClaims();
            log.info("[finaliza] TokenService - extração do ID do Token");
            return Optional.of(claims.getSubject());
        }
    }
}
