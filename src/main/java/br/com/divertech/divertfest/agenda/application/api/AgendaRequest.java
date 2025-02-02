package br.com.divertech.divertfest.agenda.application.api;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class AgendaRequest {
    private UUID idBrinquedo;
    @NotEmpty(message = "Informe o local de reserva")
    private String endereco;
    @NotNull(message = "Informe a data de reserva!")
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalTime hora_inicio;   // Hora de início da locação
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalTime hora_fim;      // Hora de fim da locação
}