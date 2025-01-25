package br.com.divertech.divertfest.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/")
public interface AgendaAPI {

    @PostMapping("agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    AgendaCriadaResponse agendamento(@RequestHeader(name = "Authorization", required = true) String token, @RequestBody AgendaRequest agendamento);

    //(locatario) - DIV 26
    @GetMapping("locatario/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    List<AgendamentoResponse> historicoLocacoes(@RequestHeader(name = "Authorization", required = true) String token);

    //(locador) - DIV 25
    @GetMapping("locador/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    List<AgendamentoResponse> historicoLocacoesLocador(@RequestHeader(name = "Authorization", required = true) String token);

    //altera status do agendamento para confirmado - DIV 44
    @PutMapping("admin/agendamentos/{idAgendamento}/confirmar")
    @ResponseStatus(HttpStatus.OK)
    void confirmarAgendamento(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String idAgendamento);

    //DIV 36 - Visualizar todas as locações finalizadas
    @GetMapping("locador/agendamentos/finalizados")
    @ResponseStatus(HttpStatus.OK)
    List<AgendamentoResponse> historicoLocacoesFinalizadas(@RequestHeader(name = "Authorization", required = true) String token);

    //Admin - Altera o status do agendamento para finalizado.
    @PutMapping("admin/agendamentos/{idAgendamento}/finalizar")
    @ResponseStatus(HttpStatus.OK)
    void finalizarAgendamento(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String idAgendamento);
}