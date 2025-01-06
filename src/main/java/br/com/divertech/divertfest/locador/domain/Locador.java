package br.com.divertech.divertfest.locador.domain;
import br.com.divertech.divertfest.brinquedo.domain.Brinquedo;
import br.com.divertech.divertfest.credencial.domain.Role;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.usuario.common.StatusUsuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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
    @OneToMany(mappedBy = "donoBrinquedo", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public void ativa() {
        this.status = StatusUsuario.ATIVO;
        ativaBrinquedos();
    }

    public void suspende() {
        this.status = StatusUsuario.SUSPENSO;
        suspendeBrinquedos();
    }

    private void suspendeBrinquedos() {
        for(Brinquedo brinquedo:brinquedos){
            brinquedo.suspender();
        }
    }

    private void ativaBrinquedos() {
        for(Brinquedo brinquedo:brinquedos){
            brinquedo.ativar();
        }
    }

    public void checaLocadorSuspenso() {
        if (this.status.equals(StatusUsuario.SUSPENSO)) {
            throw APIException.build(HttpStatus.CONFLICT, "O locador está suspenso.");
        }
    }

    public void checaLocadorAtivo() {
        if (this.status.equals(StatusUsuario.ATIVO)) {
            throw APIException.build(HttpStatus.CONFLICT, "O locador está ativo.");
        }
    }

}