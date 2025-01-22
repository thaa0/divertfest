package br.com.divertech.divertfest.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
public interface AgendaAPI {

    @PostMapping("agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    AgendaCriadaResponse agendamento(@RequestHeader(name = "Authorization", required = true)
                                     String token, @RequestBody AgendaRequest agendamento);
}