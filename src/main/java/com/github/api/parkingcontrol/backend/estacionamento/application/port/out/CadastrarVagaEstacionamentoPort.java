package com.github.api.parkingcontrol.backend.estacionamento.application.port.out;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;

public interface CadastrarVagaEstacionamentoPort {

    VagaEstacionamento cadastrarVagaEstacionamento(VagaEstacionamento vagaEstacionamento);
}