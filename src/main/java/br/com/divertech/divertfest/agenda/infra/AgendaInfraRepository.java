package br.com.divertech.divertfest.agenda.infra;

import br.com.divertech.divertfest.agenda.application.repository.AgendaRepository;
import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.agenda.domain.StatusAgenda;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class AgendaInfraRepository implements AgendaRepository {
    private final AgendaSpringDataJPARepository agendaSpringDataJPARepository;

    @Override
    public int countAgendamentosByBrinquedoAndDataAndHora(UUID idBrinquedo, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) {
        return agendaSpringDataJPARepository.countAgendamentosByBrinquedoAndDataReservaAndHorario(idBrinquedo, dataReserva, horaInicio, horaFim);
    }

    @Override
    public void salva(Agenda agenda) {
        log.info("[start] AgendaInfraRepository - salva");
        agendaSpringDataJPARepository.save(agenda);
        log.debug("[finish] AgendaInfraRepository - salva");
    }

    @Override
    public List<Agenda> buscaAgendamentosPorLocatario(Locatario locatario) {
        log.info("[start] AgendaInfraRepository - buscaAgendamentosPorLocatario");
        List<Agenda> agendamentos = agendaSpringDataJPARepository.findByLocatarioAndStatus(locatario, StatusAgenda.CONFIRMADO);
        log.debug("[finish] AgendaInfraRepository - buscaAgendamentosPorLocatario");
        return agendamentos;
    }

    @Override
    public Agenda buscaAgendamentoPorId(String idAgendamento) {
        log.info("[start] AgendaInfraRepository - buscaAgendamentoPorId");
        Agenda agenda = agendaSpringDataJPARepository.findById(UUID.fromString(idAgendamento))
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        log.debug("[finish] AgendaInfraRepository - buscaAgendamentoPorId");
        return agenda;
    }



    @Override
    public List<Agenda> buscaAgendamentosPorLocador(Locador locador) {
        log.info("[start] AgendaInfraRepository - buscaAgendamentosPorLocador");
        List<Agenda> agendamentos = agendaSpringDataJPARepository.findByLocadorAndStatus(locador, StatusAgenda.CONFIRMADO);
        log.debug("[finish] AgendaInfraRepository - buscaAgendamentosPorLocador");
        return agendamentos;
    }
}
