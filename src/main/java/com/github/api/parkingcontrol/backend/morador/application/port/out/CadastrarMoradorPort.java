package com.github.api.parkingcontrol.backend.morador.application.port.out;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;

public interface CadastrarMoradorPort {

    Morador cadastrarMorador(Morador morador);
}