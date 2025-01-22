package br.com.divertech.divertfest.agenda.application.api;

import br.com.divertech.divertfest.agenda.application.service.AgendaService;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class AgendaController implements AgendaAPI {
    private final TokenService tokenService;
    private final AgendaService agendaService;

    @Override
    public AgendaCriadaResponse agendamento(String token, AgendaRequest agendamento) {
        log.info("[start] AgendaController - agendamento");
        String emailLocatario = getUsuarioByToken(token);
        AgendaCriadaResponse agendamentoCriado = agendaService.reservarBrinquedo(emailLocatario, agendamento);
        log.debug("[finish] AgendaController - agendamento");
        return agendamentoCriado;
    }

    private String getUsuarioByToken(String token) {
        log.debug("[token] {}", token);
        String locatario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[locador] {}", locatario);
        return locatario;
    }
}
