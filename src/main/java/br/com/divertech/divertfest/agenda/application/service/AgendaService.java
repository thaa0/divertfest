package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.api.AgendaCriadaResponse;
import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;
import br.com.divertech.divertfest.agenda.application.api.AgendamentoResponse;

import java.util.List;

public interface AgendaService {
    AgendaCriadaResponse reservarBrinquedo(String emailLocatario, AgendaRequest agendamento);
    List<AgendamentoResponse> historicoLocacoesLocador(String emailLocador);
    List<AgendamentoResponse> historicoLocacoes(String emailLocatario);

    void confirmaAgendamento(String idAgendamento);
}
