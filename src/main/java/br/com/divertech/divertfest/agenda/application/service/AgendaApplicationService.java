package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.application.api.AgendaCriadaResponse;
import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;
import br.com.divertech.divertfest.agenda.application.api.AgendamentoResponse;
import br.com.divertech.divertfest.agenda.application.repository.AgendaRepository;
import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.brinquedo.application.repository.BrinquedoRepository;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.repository.LocadorRepository;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.application.repository.LocatarioRepository;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class AgendaApplicationService implements AgendaService {
    private final LocatarioRepository locatarioRepository;
    private final LocadorRepository locadorRepository;
    private final BrinquedoRepository brinquedoRepository;
    private final AgendaRepository agendaRepository;
    private final EmailSenderService emailSenderService;

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

    @Override
    public List<AgendamentoResponse> historicoLocacoes(String emailLocatario) {
        log.info("[start] AgendaApplicationService - historicoLocacoes");
        Locatario locatario = locatarioRepository.buscaLocatario(emailLocatario);
        List<Agenda> agendamentos = agendaRepository.buscaAgendamentosPorLocatario(locatario);
        log.debug("[finish] AgendaApplicationService - historicoLocacoes");
        return AgendamentoResponse.from(agendamentos);
    }

    public List<AgendamentoResponse> historicoLocacoesLocador(String emailLocador){
        log.info("[start] AgendaApplicationService - historicoLocacoesLocador");
        Locador locador = locadorRepository.buscaLocador(emailLocador);
        List<Agenda> agendamentos = agendaRepository.buscaAgendamentosPorLocador(locador);
        log.debug("[finish] AgendaApplicationService - historicoLocacoesLocador");
        return AgendamentoResponse.from(agendamentos);
    }

    @Override
    public void confirmaAgendamento(String idAgendamento) {
        log.info("[start] AgendaApplicationService - confirmaAgendamento");
        Agenda agenda = agendaRepository.buscaAgendamentoPorId(idAgendamento);
        agenda.confirmaAgendamento();
        agendaRepository.salva(agenda);
        log.debug("[finish] AgendaApplicationService - confirmaAgendamento");
    }

    @Override
    public List<AgendamentoResponse> historicoLocacoesFinalizadas(String emailLocador) {
        log.info("[start] AgendaApplicationService - historicoLocacoesFinalizadas");
        Locador locador = locadorRepository.buscaLocador(emailLocador);
        List<Agenda> agendamentos = agendaRepository.buscaAgendamentosFinalizadosPorLocador(locador);
        log.debug("[finish] AgendaApplicationService - historicoLocacoesFinalizadas");
        return AgendamentoResponse.from(agendamentos);
    }

    @Override
    public void finalizarAgendamento(String idAgendamento) {
        log.info("[start] AgendaApplicationService - finalizarAgendamento");
        Agenda agenda = agendaRepository.buscaAgendamentoPorId(idAgendamento);
        agenda.finalizaAgendamento();
        agendaRepository.salva(agenda);
        log.debug("[finish] AgendaApplicationService - finalizarAgendamento");
    }

    @Override
    public void cancelaAgendamento(UUID idAgendamento, String email) {
        log.info("[start] AgendaApplicationService - cancelaAgendamento");
        Locatario locatario = locatarioRepository.buscaLocatario(email);
        Agenda agendamento = agendaRepository.buscaAgendamentoPorId(String.valueOf(idAgendamento));
        agendamento.pertenceAoLocatario(locatario);
        agendamento.validaSePodeCancelar();
        agendamento.cancela();
        agendaRepository.salva(agendamento);
        try {
            emailSenderService.sendCancelamento(agendamento);
        } catch (Exception e) {
            log.error("[error] Falha ao enviar e-mail de cancelamento - {}", e.getMessage());
        }
        log.debug("[finish] AgendaApplicationService - cancelaAgendamento");
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