package br.com.divertech.divertfest.agenda.application.api;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class AgendaRequest {
    private UUID idBrinquedo;         // Brinquedo reservado
    @NotNull(message = "Informe a data de reserva!")
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalDateTime hora_inicio;   // Hora de início da locação
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalDateTime hora_fim;      // Hora de fim da locação
}