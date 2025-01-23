package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.api.AgendaCriadaResponse;
import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;
import br.com.divertech.divertfest.agenda.application.repository.AgendaRepository;
import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.infra.LocadorSpringDataJPARepository;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RequiredArgsConstructor
@Log4j2
@Service
public class AgendaApplicationService implements AgendaService {
    private final LocatarioRepository locatarioRepository;
    private final BrinquedoRepository brinquedoRepository;
    private final AgendaRepository agendaRepository;

    @Override
    public AgendaCriadaResponse reservarBrinquedo(String emailLocatario, AgendaRequest agendamento) {
        log.info("[start] AgendaApplicationService - reservarBrinquedo");
        Locatario locatario = locatarioRepository.buscaLocatario(emailLocatario);
        locatario.checaLocatarioSuspenso();
        Brinquedo brinquedo = brinquedoRepository.buscaBrinquedoPorId(agendamento.getIdBrinquedo());
        boolean isDisponivel = isBrinquedoDisponivel(brinquedo, agendamento.getDataReserva(), agendamento.getHora_inicio(), agendamento.getHora_fim());
        if(!isDisponivel){
            throw APIException.build(HttpStatus.CONFLICT, "Esse brinquedo não está disponivel!");
        }
        Agenda agenda = new Agenda(agendamento, brinquedo, locatario);
        agendaRepository.salva(agenda);
        log.debug("[finish] AgendaApplicationService - reservarBrinquedo");
        return new AgendaCriadaResponse(agenda);
    }

    private boolean isBrinquedoDisponivel(Brinquedo brinquedo, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) {
        log.info("[start] AgendaApplicationService - isBrinquedoDisponivel");
        int count = agendaRepository.countAgendamentosByBrinquedoAndDataAndHora(brinquedo.getIdBrinquedo(), dataReserva, horaInicio, horaFim);
        log.info("[Numero de agendamento com brinquedo] - {}", count);
        boolean disponivel = count == 0;
        log.info("[Brinquedo Disp] - {}", disponivel);
        log.debug("[finish] AgendaApplicationService - isBrinquedoDisponivel");
    return disponivel;
    }
}