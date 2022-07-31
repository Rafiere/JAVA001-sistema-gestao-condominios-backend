package com.github.api.parkingcontrol.backend.estacionamento.application.port.out;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;

import java.util.List;

public interface BuscarVagasEstacionamentoPorIdsPort {

    List<VagaEstacionamento> buscarVagasEstacionamentoPorIds(List<String> vagasEstacionamentoId);
}