package com.github.api.parkingcontrol.backend.usuario.domain;

import com.github.api.parkingcontrol.backend.usuario.domain.enums.TipoDeCargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo implements GrantedAuthority {

    private String id;
    private TipoDeCargo cargo;

    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {

        return this.cargo.toString();
    }
}
