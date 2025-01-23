package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import br.com.divertech.divertfest.usuario.common.StatusUsuario;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class LocatarioCriadoResponse {
    private UUID idUsuario;
    private String email;
    private StatusUsuario status;
    private List<Agenda> agendametos;

    public LocatarioCriadoResponse(Locatario locatario) {
        this.idUsuario = locatario.getIdUsuario();
        this.email = locatario.getEmail();
        this.status = locatario.getStatus();
        this.agendametos = locatario.getAgendametos();
    }
}
