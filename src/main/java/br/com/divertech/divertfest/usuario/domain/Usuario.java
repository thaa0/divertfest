package br.com.divertech.divertfest.usuario.domain;

import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Usuario {
    @Id
    private UUID idUsuario;
    @Email
    @Column(unique = true)
    private String email;
    private StatusUsuario status;

    public Usuario(UsuarioNovoRequest usuarioNovo) {
        this.idUsuario = UUID.randomUUID();
        this.email = usuarioNovo.getEmail();
        this.status = StatusUsuario.ATIVO;
    }

    public void alteraStatusCancelado() {
        this.status = StatusUsuario.CANCELADO;
    }
}
