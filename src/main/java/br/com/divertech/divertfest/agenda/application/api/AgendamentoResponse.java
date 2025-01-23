package br.com.divertech.divertfest.agenda.application.api;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class AgendamentoResponse {
    private UUID idAgendamento;
    private UUID idBrinquedo;
    private String nomeBrinquedo;
    private String dataReserva;
    private String horaInicio;
    private String horaFim;
    private String status;

    public AgendamentoResponse(Agenda agenda) {
        this.idAgendamento = agenda.getId();
        this.idBrinquedo = agenda.getBrinquedo().getIdBrinquedo();
        this.nomeBrinquedo = agenda.getBrinquedo().getNome();
        this.dataReserva = agenda.getDataReserva().toString();
        this.horaInicio = agenda.getHora_inicio().toString();
        this.horaFim = agenda.getHora_fim().toString();
        this.status = agenda.getStatus().name();
    }

    public static List<AgendamentoResponse> from(List<Agenda> agendamentos) {
        return agendamentos.stream().map(AgendamentoResponse::new).toList();
    }
}