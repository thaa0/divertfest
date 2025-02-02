package br.com.divertech.divertfest.agenda.application.service;

import br.com.divertech.divertfest.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmailSender implements EmailSenderService {

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String remetente;

    @Override
    public void sendCancelamento(Agenda agendamento) {
        log.info("[start] EmailSender - sendCancelamento");

        try {
            // Criando a mensagem MIME
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Remetente e destinatário
            helper.setFrom(remetente);
            helper.setTo(agendamento.getLocador().getEmail());
            helper.setSubject("CANCELAMENTO DE AGENDAMENTO");

            // Corpo do e-mail (HTML)
            String corpo = "<p>Prezado(a) " + agendamento.getLocador().getNome() + ",</p>" +
                    "<p>Lamentamos informar que o seu agendamento foi cancelado. Abaixo estão os detalhes do agendamento cancelado:</p>" +
                    "<ul>" +
                    "<li><b>ID do Agendamento:</b> " + agendamento.getId() + "</li>" +
                    "<li><b>Data do Agendamento:</b> " + agendamento.getDataReserva() + "</li>" +
                    "<li><b>Hora de Início:</b> " + agendamento.getHora_inicio() + "</li>" +
                    "<li><b>Hora de Término:</b> " + agendamento.getHora_fim() + "</li>" +
                    "<li><b>Brinquedo:</b> " + agendamento.getBrinquedo().getNome() + "</li>" +
                    "</ul>" +
                    "<p>Pedimos desculpas pelo inconveniente e estamos à disposição para mais informações.</p>" +
                    "<p>Atenciosamente,<br>Equipe DivertFest</p>";

            helper.setText(corpo, true);

            javaMailSender.send(message);
            log.debug("[finish] EmailSender - sendCancelamento");

        } catch (MessagingException | MailException e) {
            log.error("[error] EmailSender - sendCancelamento - {}", e.getMessage());
        }
    }
}
