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

    public void ativarContaDoUsuario(){

        this.isAtivo = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.cargos;
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

        return this.isAtivo;
    }
}
