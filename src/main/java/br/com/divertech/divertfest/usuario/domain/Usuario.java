package br.com.divertech.divertfest.usuario.domain;

import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Usuario {
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


    public Usuario(UsuarioNovoRequest usuarioNovo) {
        this.nome = usuarioNovo.getNome();
        this.razaoSocial = usuarioNovo.getRazaoSocial();
        this.telefone = usuarioNovo.getTelefone();
        this.documentoIdentificador = usuarioNovo.getDocumentoIdentificador();
        this.endereco = usuarioNovo.getEndereco();
        this.email = usuarioNovo.getEmail();
        this.status = StatusUsuario.ATIVO;
    }


    public void alteraStatusCancelado() {
        this.status = StatusUsuario.SUSPENSO;
    }
}
