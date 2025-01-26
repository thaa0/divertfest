package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.repository.AgendaRepository;
import br.com.divertech.divertfest.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SchedulerService {
    private final AgendaRepository agendaRepository;

    @Scheduled(cron = "1 * * * * *")
    public void finalizaAgendamentos() {
        log.info("[start] SchedulerService - finalizaAgendamentos");
        List<Agenda> agendamentos = agendaRepository.buscaAgendamentosConfirmados();
        agendamentos.forEach(agendamento -> {
            if(momentoAgendadoExpirou(agendamento.getDataReserva(),agendamento.getHora_fim())){
                log.info("[scheduler] finalizaAgendamento - {}", agendamento.getBrinquedo().getNome());
                agendamento.finalizaAgendamento();
                agendaRepository.salva(agendamento);
            }
        });
        log.debug("[finish] SchedulerService - finalizaAgendamentos");
    }

    private boolean momentoAgendadoExpirou(LocalDate dataReserva, LocalTime horaFim) {
        return dataReserva.isBefore(LocalDate.now());
    }
}
