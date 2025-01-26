package br.com.divertech.divertfest.agenda.application.repository;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.domain.Locatario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface AgendaRepository {
    int countAgendamentosByBrinquedoAndDataAndHora(UUID idBrinquedo, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim);
    void salva(Agenda agenda);
    List<Agenda> buscaAgendamentosPorLocatario(Locatario locatario);
    Agenda buscaAgendamentoPorId(String idAgendamento);
    List<Agenda> buscaAgendamentosPorLocador(Locador locador);
    List<Agenda> buscaAgendamentosFinalizadosPorLocador(Locador locador);
    List<Agenda> buscaAgendamentosConfirmados();
}
