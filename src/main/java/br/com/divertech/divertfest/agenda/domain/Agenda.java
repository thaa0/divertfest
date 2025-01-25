package br.com.divertech.divertfest.agenda.domain;

import br.com.divertech.divertfest.agenda.application.api.AgendaRequest;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;                    // Identificador único do item no carrinho
    @ManyToOne
    @JsonBackReference
    private Locatario locatario;
    @ManyToOne
    private Brinquedo brinquedo;         // Brinquedo reservado
    @NotNull(message = "Informe a data de reserva!")
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalTime hora_inicio;   // Hora de início da locação
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalTime hora_fim;      // Hora de fim da locação  // Hora de fim da locação
    @Column(precision = 10, scale = 2)
    private BigDecimal precoTotal;       // Preço total da locação do brinquedo
    private StatusAgenda status;
    @ManyToOne
    private Locador locador;

    public Agenda(AgendaRequest agendamento, Brinquedo brinquedo, Locatario locatario) {
        this.status = StatusAgenda.AGUARDANDO_PAGAMENTO;
        this.precoTotal = calculoPrecoPorHora(brinquedo.getPrecoPorHora(),agendamento.getHora_inicio(),agendamento.getHora_fim());
        this.hora_fim = agendamento.getHora_fim();
        this.hora_inicio = agendamento.getHora_inicio();
        this.dataReserva = agendamento.getDataReserva();
        this.brinquedo = brinquedo;
        this.locatario = locatario;
        this.locador = brinquedo.getDonoBrinquedo();
    }

    private BigDecimal calculoPrecoPorHora(BigDecimal precoPorHora, LocalTime horaInicio,LocalTime horaFim) {
        long horas = java.time.Duration.between(horaInicio, horaFim).toHours();
        return precoPorHora.multiply(BigDecimal.valueOf(horas));
    }

    public void confirmaAgendamento() {
        this.status = StatusAgenda.CONFIRMADO;
    }

    public void finalizaAgendamento() {
        this.status = StatusAgenda.FINALIZADO;
    }
}