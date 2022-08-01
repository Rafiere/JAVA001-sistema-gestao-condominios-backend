package com.github.api.parkingcontrol.backend.usuario.adapter.in.web.command;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import lombok.Value;

import java.util.List;

@Value
public class CadastrarUsuarioCommand {

    String email;

    String username;

    String password;

    boolean isAtivo;

    List<Cargo> cargos;
}
