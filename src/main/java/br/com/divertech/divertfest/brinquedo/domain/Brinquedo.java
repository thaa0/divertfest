package br.com.divertech.divertfest.brinquedo.domain;

import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoEditaRequest;
import br.com.divertech.divertfest.brinquedo.application.api.BrinquedoRequest;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idBrinquedo;
    @NotBlank(message = "O campo nome não pode ficar em branco")
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private StatusBrinquedo status;
    @Column(precision = 10, scale = 2)
    private BigDecimal precoPorHora;
    @NotBlank
    private String imagem;
    @ManyToOne
    private Locador donoBrinquedo;


    public Brinquedo(BrinquedoRequest brinquedoRequest, Locador locador) {
        this.nome = brinquedoRequest.getNome();
        this.descricao = brinquedoRequest.getDescricao();
        this.categoria = brinquedoRequest.getCategoria();
        this.status = StatusBrinquedo.DISPONIVEL;
        this.precoPorHora = brinquedoRequest.getPrecoPorHora();
        this.imagem = brinquedoRequest.getImagem();
        this.donoBrinquedo = locador;
    }

    public void edita(BrinquedoEditaRequest brinquedoRequest) {
        this.nome = brinquedoRequest.getNome();
        this.descricao = brinquedoRequest.getDescricao();
        this.categoria = brinquedoRequest.getCategoria();
        this.precoPorHora = brinquedoRequest.getPrecoPorHora();
        this.imagem = brinquedoRequest.getImagem();
    }

    public boolean estaAtivo() {
        return this.status.equals(StatusBrinquedo.DISPONIVEL);
    }

    public void pertenceAoLocador(Locador locador) {
        if(!this.donoBrinquedo.getIdUsuario().equals(locador.getIdUsuario())) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Locador não é dono do brinquedo!");
        }
    }
}