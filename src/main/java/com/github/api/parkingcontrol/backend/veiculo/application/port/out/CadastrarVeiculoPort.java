package com.github.api.parkingcontrol.backend.veiculo.application.port.out;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;

public interface CadastrarVeiculoPort {

    Veiculo cadastrarVeiculo(Veiculo veiculo);
}
