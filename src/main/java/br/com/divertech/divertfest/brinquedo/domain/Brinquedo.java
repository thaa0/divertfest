package br.com.divertech.divertfest.brinquedo.domain;

import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
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
    private String categoria;
    @Enumerated(EnumType.STRING)
    private StatusBrinquedo status;
    @NotBlank
    private String imagem;

    public Brinquedo() {

    }
}