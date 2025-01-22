package br.com.divertech.divertfest.agenda.infra;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, UUID> {
}
