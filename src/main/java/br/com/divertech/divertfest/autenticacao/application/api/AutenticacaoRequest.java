package br.com.divertech.divertfest.autenticacao.application.api;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutenticacaoRequest {
    @Schema(description = "E-mail do usuário", example = "usuario@exemplo.com")
    @NotBlank(message = "O usuário não pode estar em branco!")
    @Column(unique = true)
    @Email
    private String usuario;
    @Schema(description = "Senha do usuário", example = "senha123")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotNull
    private String senha;

    @JsonIgnore
    public UsernamePasswordAuthenticationToken getUserPassToken() {
        return new UsernamePasswordAuthenticationToken(usuario, senha);
    }
}