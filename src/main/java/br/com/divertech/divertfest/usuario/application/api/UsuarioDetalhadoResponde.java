package br.com.divertech.divertfest.usuario.application.api;

import br.com.divertech.divertfest.usuario.domain.StatusUsuario;
import br.com.divertech.divertfest.usuario.domain.Usuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UsuarioDetalhadoResponde {
    private final UUID idUsuario;
    private final String nome;
    private final String razaoSocial;
    private final String telefone;
    private final String documentoIdentificador;
    private final String endereco;
    private final String email;
    private final StatusUsuario status;

    public UsuarioDetalhadoResponde(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.razaoSocial = usuario.getRazaoSocial();
        this.telefone = usuario.getTelefone();
        this.documentoIdentificador = usuario.getDocumentoIdentificador();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.status = usuario.getStatus();
    }
}