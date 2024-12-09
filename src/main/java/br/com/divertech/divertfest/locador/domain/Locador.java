package br.com.divertech.divertfest.locador.domain;

import br.com.divertech.divertfest.credencial.domain.Role;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Locador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true,nullable = false)
    private UUID idUsuario;
    @NotBlank(message="o campo nao pode estar em branco")
    private String nome;
    private String razaoSocial;
    @NotBlank(message="o campo nao pode estar em branco")
    private String telefone;
    @NotBlank(message="o campo nao pode estar em branco")
    @Column(unique = true)
    private String documentoIdentificador;
    @NotBlank(message="o campo nao pode estar em branco")
    private String endereco;
    @Email
    @Column(unique = true)
    private String email;
    @OneToMany
    private List<Brinquedo> brinquedos;
    private Role tipoUsuario;
    private StatusUsuario status;

    public Locador(LocadorNovoRequest locadorNovo) {
        this.nome = locadorNovo.getNome();
        this.razaoSocial = locadorNovo.getRazaoSocial();
        this.telefone = locadorNovo.getTelefone();
        this.documentoIdentificador = locadorNovo.getDocumentoIdentificador();
        this.endereco = locadorNovo.getEndereco();
        this.email = locadorNovo.getEmail();
        this.status = StatusUsuario.ATIVO;
        this.tipoUsuario = Role.LOCADOR;
    }
}