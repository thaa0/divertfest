package br.com.divertech.divertfest.agenda.application.api;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.agenda.domain.StatusAgenda;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class AgendaCriadaResponse {
    private UUID id;                    // Identificador único do item no carrinho
    private UUID locatario;
    private String nomeLocatario;
    private UUID brinquedo;         // Brinquedo reservado
    private String nomeBrinquedo;
    private BigDecimal precoPorHora;
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    private LocalTime hora_inicio;   // Hora de início da locação
    private LocalTime hora_fim;      // Hora de fim da locação  // Hora de fim da locação
    private BigDecimal precoTotal;       // Preço total da locação do brinquedo
    private StatusAgenda status;

    public AgendaCriadaResponse(Agenda agenda) {
        this.id = agenda.getId();
        this.locatario = agenda.getLocatario().getIdUsuario();
        this.nomeLocatario = agenda.getLocatario().getNome();
        this.brinquedo = agenda.getBrinquedo().getIdBrinquedo();
        this.nomeBrinquedo = agenda.getBrinquedo().getNome();
        this.precoPorHora = agenda.getBrinquedo().getPrecoPorHora();
        this.dataReserva = agenda.getDataReserva();
        this.hora_inicio = agenda.getHora_inicio();
        this.hora_fim = agenda.getHora_fim();
        this.precoTotal = agenda.getPrecoTotal();
        this.status = agenda.getStatus();
    }
}