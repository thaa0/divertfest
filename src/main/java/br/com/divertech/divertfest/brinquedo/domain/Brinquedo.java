package br.com.divertech.divertfest.brinquedo.domain;

import br.com.divertech.divertfest.locador.domain.Locador;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private StatusBrinquedo status;
    @NotBlank
    private String imagem;
    @ManyToOne
    private Locador donoBrinquedo;
}