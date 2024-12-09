package br.com.divertech.divertfest.locatario.application.api;

import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class LocatarioNovoRequest {
    @Email
    private String email;
    @Size(min = 6)
    private String senha;
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
}