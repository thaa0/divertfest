package br.com.divertech.divertfest.credencial.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Credencial implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idCredencial;
    @Getter
    @NotBlank
    private String usuario;
    @NotNull
    @Size(max = 60)
    private String senha;
    private Role role;
    @Getter
    private boolean validado;

    public Credencial(String usuario, @NotNull String senha, Role role) {
        this.usuario = usuario;
        var encriptador = new BCryptPasswordEncoder();
        this.senha = encriptador.encode(senha);
        this.role = role;
        this.validado = true;
    }

    public void encriptaSenha() {
        var encriptador = new BCryptPasswordEncoder();
        this.senha = encriptador.encode(this.senha);
    }

    public void validaCredencial() {
        this.validado = true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
