package br.com.divertech.divertfest.agenda.infra;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import br.com.divertech.divertfest.agenda.domain.StatusAgenda;
import br.com.divertech.divertfest.locador.domain.Locador;
import br.com.divertech.divertfest.locatario.domain.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, UUID> {

    @Query("SELECT COUNT(a) FROM Agenda a " +
             "WHERE a.brinquedo.idBrinquedo = :idBrinquedo " +
            "AND a.dataReserva = :dataReserva " +
            "AND (a.hora_inicio < :horaFim AND a.hora_fim > :horaInicio)")
    int countAgendamentosByBrinquedoAndDataReservaAndHorario(
            @Param("idBrinquedo") UUID idBrinquedo,
            @Param("dataReserva") LocalDate dataReserva,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFim") LocalTime horaFim
    );

    List<Agenda> findByLocatario(Locatario locatario);

    List<Agenda> findByLocatarioAndStatus(Locatario locatario, StatusAgenda status);

    List<Agenda> findByLocadorAndStatus(Locador locador, StatusAgenda statusAgenda);
}
