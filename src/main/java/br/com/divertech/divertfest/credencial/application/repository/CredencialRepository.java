package br.com.divertech.divertfest.credencial.application.repository;

import br.com.divertech.divertfest.credencial.domain.Credencial;

public interface CredencialRepository {
    void salva(Credencial novaCredencial);
}
