package com.github.api.parkingcontrol.backend.veiculo.application.port.out;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;

import java.util.List;

public interface BuscarVeiculosPorIdsPort {

    List<Veiculo> buscarVeiculosPorIds(List<String> idsVeiculos);
}