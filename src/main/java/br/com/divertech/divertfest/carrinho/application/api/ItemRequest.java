package br.com.divertech.divertfest.carrinho.application.api;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ItemRequest {
    @NotNull(message = "O brinquedo deve ser informado para locação!")
    private UUID idBrinquedo;         // Brinquedo reservado
    @NotNull(message = "Informe a data de reserva!")
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalDateTime hora_inicio;   // Hora de início da locação
    @NotNull(message = "Não esqueça de informar o horário!")
    private LocalDateTime hora_fim;      // Hora de fim da locação
}