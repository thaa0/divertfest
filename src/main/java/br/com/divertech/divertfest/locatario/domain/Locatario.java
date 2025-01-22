package br.com.divertech.divertfest.locatario.domain;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.credencial.domain.Role;
import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;
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
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true,nullable = false)
    private UUID idUsuario;
    @NotBlank(message="o campo nao pode estar em branco")
    private String nome;
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
    private StatusUsuario status;
    private Role tipoUsuario;
    @OneToMany(mappedBy = "locatario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agenda> agendametos;

    public Locatario(LocatarioNovoRequest locatarioNovo) {
        this.nome = locatarioNovo.getNome();
        this.telefone = locatarioNovo.getTelefone();
        this.documentoIdentificador = locatarioNovo.getDocumentoIdentificador();
        this.endereco = locatarioNovo.getEndereco();
        this.email = locatarioNovo.getEmail();
        this.status = StatusUsuario.ATIVO;
        this.tipoUsuario = Role.LOCATARIO;
    }

    public void suspende() {
        this.status = StatusUsuario.SUSPENSO;
    }

    public void checaLocatarioSuspenso() {
        if (this.status.equals(StatusUsuario.SUSPENSO)) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Locatario está suspenso!");
        }
    }

    public void ativa() {
        this.status = StatusUsuario.ATIVO;
    }

    public void checaLocatarioAtivo() {
        if (this.status.equals(StatusUsuario.ATIVO)) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Locatario já ativo!");
        }
    }
}
