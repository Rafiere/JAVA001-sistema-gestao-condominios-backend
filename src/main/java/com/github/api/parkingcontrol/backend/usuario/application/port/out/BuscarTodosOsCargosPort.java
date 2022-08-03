package com.github.api.parkingcontrol.backend.usuario.application.port.out;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;

import java.util.List;

public interface BuscarTodosOsCargosPort {

    List<Cargo> buscarTodosOsCargos();
}