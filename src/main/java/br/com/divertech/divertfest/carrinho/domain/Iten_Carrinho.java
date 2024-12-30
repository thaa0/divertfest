package br.com.divertech.divertfest.carrinho.domain;

import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Iten_Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;                    // Identificador único do item no carrinho
    @ManyToOne
    private Carrinho carrinho;           // Carrinho ao qual o item pertence
    @ManyToOne
    private Brinquedo brinquedo;         // Brinquedo reservado
    @NotNull
    private LocalDate dataReserva;       // Data da reserva do brinquedo
    @NotNull
    private LocalDateTime hora_inicio;   // Hora de início da locação
    @NotNull
    private LocalDateTime hora_fim;      // Hora de fim da locação
    @Column(precision = 10, scale = 2)
    private BigDecimal precoTotal;       // Preço total da locação do brinquedo
}