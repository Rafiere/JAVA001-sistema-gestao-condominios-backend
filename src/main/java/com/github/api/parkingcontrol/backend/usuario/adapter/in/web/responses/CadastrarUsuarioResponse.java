package com.github.api.parkingcontrol.backend.usuario.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.Value;

@Value
public class CadastrarUsuarioResponse {

    String id;

    String email;

    String username;

    String password;

    boolean isAtivo;

    public static CadastrarUsuarioResponse of(Usuario usuario){

        return new CadastrarUsuarioResponse(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.isAtivo());
    }
}
