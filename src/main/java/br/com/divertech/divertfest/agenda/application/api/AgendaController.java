package br.com.divertech.divertfest.agenda.application.api;

import br.com.divertech.divertfest.agenda.application.service.AgendaService;
import br.com.divertech.divertfest.config.security.service.TokenService;
import br.com.divertech.divertfest.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    //deve retornar somente agendamentos com status confirmado
    @Override
    public List<AgendamentoResponse> historicoLocacoes(String token) {
        log.info("[start] AgendaController - historicoLocacoes");
        String emailLocatario = getUsuarioByToken(token);
        List<AgendamentoResponse> historicoLocacoes = agendaService.historicoLocacoes(emailLocatario);
        log.debug("[finish] AgendaController - historicoLocacoes");
        return historicoLocacoes;
    }

    @Override
    public List<AgendamentoResponse> historicoLocacoesLocador(String token) {
        log.info("[start] AgendaController - historicoLocacoesLocador");
        String emailLocador = getUsuarioByToken(token);
        List<AgendamentoResponse> historicoLocacoes = agendaService.historicoLocacoesLocador(emailLocador);
        log.debug("[finish] AgendaController - historicoLocacoesLocador");
        return historicoLocacoes;
    }

    //confirma agendamento (somente locadores)
    @Override
    public void confirmarAgendamento(String token, String idAgendamento) {
        log.info("[start] AgendaController - confirmarAgendamento");
        String email = getUsuarioByToken(token);
        agendaService.confirmaAgendamento( idAgendamento);
        log.info("[emailLocatario] {}", email);
        log.debug("[finish] AgendaController - confirmarAgendamento");

    }

    @Override
    public List<AgendamentoResponse> historicoLocacoesFinalizadas(String token) {
        log.info("[start] AgendaController - historicoLocacoesFinalizadas");
        String emailLocador = getUsuarioByToken(token);
        List<AgendamentoResponse> historicoLocacoes = agendaService.historicoLocacoesFinalizadas(emailLocador);
        log.debug("[finish] AgendaController - historicoLocacoesFinalizadas");
        return historicoLocacoes;
    }

    @Override
    public void finalizarAgendamento(String token, String idAgendamento) {
        log.info("[start] AgendaController - finalizarAgendamento");
        String email = getUsuarioByToken(token);
        agendaService.finalizarAgendamento(idAgendamento);
        log.info("[emailLocatario] {}", email);
        log.debug("[finish] AgendaController - finalizarAgendamento");
    }

    @Override
    public void cancelaAgendamento(String token, UUID idAgendamento) {
        log.info("[start] AgendaController - cancelaAgendamento");
        String email = getUsuarioByToken(token);
        agendaService.cancelaAgendamento(idAgendamento, email);
        log.debug("[finish] AgendaController - cancelaAgendamento");
    }


    private String getUsuarioByToken(String token) {
        log.debug("[token] {}", token);
        String locatario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[locador] {}", locatario);
        return locatario;
    }
}
