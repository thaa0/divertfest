package br.com.divertech.divertfest.credencial.application.service;


import br.com.divertech.divertfest.credencial.domain.Credencial;
import br.com.divertech.divertfest.locador.application.api.LocadorNovoRequest;
import br.com.divertech.divertfest.locatario.application.api.LocatarioNovoRequest;

public interface CredencialService{
    Credencial buscaCredencialPorUsuario(String usuario);
    void criaNovaCredencialLocador(LocadorNovoRequest locadorNovo);
    void criaNovaCredencialLocatario(LocatarioNovoRequest usuarioNovo);
}