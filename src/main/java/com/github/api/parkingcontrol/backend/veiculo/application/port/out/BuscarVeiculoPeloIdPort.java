package com.github.api.parkingcontrol.backend.veiculo.application.port.out;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;

public interface BuscarVeiculoPeloIdPort {

    Veiculo buscarVeiculoPeloId(String idVeiculo);
}