package com.github.api.parkingcontrol.backend.token.adapter.in.web.response;

import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.Value;

@Value
public class AtivarUsuarioPeloTokenResponse {

    String id;

    String email;

    String username;

    String password;

    boolean isAtivo;

    public static AtivarUsuarioPeloTokenResponse of(Usuario usuario){

        return new AtivarUsuarioPeloTokenResponse(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.isAtivo());
    }
}
