package br.com.divertech.divertfest.locatario.application.repository;

import br.com.divertech.divertfest.locatario.domain.Locatario;

public interface LocatarioRepository {
    void salva(Locatario locatarioNovo);
}
