package br.com.divertech.divertfest.brinquedo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true,nullable = false)
    private UUID idBrinquedo;
    @NotBlank(message = "O campo nome não deve estar em branco")
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