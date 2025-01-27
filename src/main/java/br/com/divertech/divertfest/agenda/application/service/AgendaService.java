package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.api.AgendaCriadaResponse;
import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;
import br.com.divertech.divertfest.agenda.application.api.AgendamentoResponse;

import java.util.List;
import java.util.UUID;

public interface AgendaService {
    AgendaCriadaResponse reservarBrinquedo(String emailLocatario, AgendaRequest agendamento);
    List<AgendamentoResponse> historicoLocacoesLocador(String emailLocador);
    List<AgendamentoResponse> historicoLocacoes(String emailLocatario);
    void confirmaAgendamento(String idAgendamento);
    List<AgendamentoResponse> historicoLocacoesFinalizadas(String emailLocador);
    void finalizarAgendamento(String idAgendamento);
    void cancelaAgendamento(UUID idAgendamento, String email);
}
