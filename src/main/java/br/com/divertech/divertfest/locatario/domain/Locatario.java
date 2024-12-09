package br.com.divertech.divertfest.locatario.domain;

import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;
import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    private StatusUsuario status;

    public Locatario(LocatarioNovoRequest locatarioNovo) {
        this.nome = locatarioNovo.getNome();
        this.razaoSocial = locatarioNovo.getRazaoSocial();
        this.telefone = locatarioNovo.getTelefone();
        this.documentoIdentificador = locatarioNovo.getDocumentoIdentificador();
        this.endereco = locatarioNovo.getEndereco();
        this.email = locatarioNovo.getEmail();
        this.status = StatusUsuario.ATIVO;
    }
}
