package com.github.api.parkingcontrol.backend.usuario.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

    private String id;

    private String email;

    private String username;

    private String password;

    private boolean isAtivo;

    private List<Cargo> cargos;

    public Usuario(String email,
                   String username,
                   String password,
                   boolean isAtivo,
                   List<Cargo> cargos) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAtivo = isAtivo;
        this.cargos = cargos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.cargos;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {

        return this.isAtivo;
    }
}
