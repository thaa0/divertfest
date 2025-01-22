package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.api.AgendaCriadaResponse;
import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;

public interface AgendaService {
    AgendaCriadaResponse reservarBrinquedo(String emailLocatario, AgendaRequest agendamento);
}
