package br.com.divertech.divertfest.agenda.application.repository;

import br.com.divertech.divertfest.agenda.domain.Agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface AgendaRepository {
    int countAgendamentosByBrinquedoAndDataAndHora(UUID idBrinquedo, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim);
    void salva(Agenda agenda);
}
