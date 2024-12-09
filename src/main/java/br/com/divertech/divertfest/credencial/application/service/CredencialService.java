package br.com.divertech.divertfest.credencial.application.service;


import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import javax.validation.Valid;

public interface CredencialService{
    Credencial buscaCredencialPorUsuario(String usuario);
    void criaNovaCredencialLocador(LocadorNovoRequest locadorNovo);
    void criaNovaCredencialLocatario(UsuarioNovoRequest usuarioNovo);
}