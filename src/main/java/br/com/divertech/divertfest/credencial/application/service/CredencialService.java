package br.com.divertech.divertfest.credencial.application.service;


import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import javax.validation.Valid;

public interface CredencialService{
    void criaNovaCredencial(@Valid UsuarioNovoRequest usuarioNovo);
}