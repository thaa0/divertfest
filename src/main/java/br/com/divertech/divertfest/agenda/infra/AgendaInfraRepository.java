package br.com.divertech.divertfest.agenda.infra;

import br.com.divertech.divertfest.agenda.application.repository.AgendaRepository;
import br.com.divertech.divertfest.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
}
