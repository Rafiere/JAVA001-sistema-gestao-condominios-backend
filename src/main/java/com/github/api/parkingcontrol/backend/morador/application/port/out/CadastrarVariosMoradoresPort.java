package com.github.api.parkingcontrol.backend.morador.application.port.out;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;

import java.util.List;

public interface CadastrarVariosMoradoresPort {

    List<Morador> cadastrarVariosMoradores(List<Morador> moradores);
}