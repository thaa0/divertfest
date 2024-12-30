package br.com.divertech.divertfest.carrinho.domain;

import br.com.divertech.divertfest.locatario.domain.Locatario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;                        // Identificador único do carrinho
    @ManyToOne
    private Locatario locatario;            // Locatário associado ao carrinho
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Iten_Carrinho> itens;       // Lista de itens no carrinho
    @Enumerated(EnumType.STRING)
    private StatusCarrinho status;          // Status do carrinho (ex.: aberto, fechado)
    @Column(precision = 10, scale = 2)
    private BigDecimal precoTotal;          // Preço total de todos os itens no carrinho
    private LocalDateTime dataCriacao;
}