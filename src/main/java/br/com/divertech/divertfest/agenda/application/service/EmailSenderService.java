package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.domain.Agenda;

public interface EmailSenderService {
    void sendCancelamento(Agenda agendamento);
}
