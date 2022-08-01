package com.github.api.parkingcontrol.backend.usuario.application.port.out;

import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;

public interface BuscarUsuarioPeloUsernamePort {

    Usuario buscarUsuarioPeloUsername(String username);
}