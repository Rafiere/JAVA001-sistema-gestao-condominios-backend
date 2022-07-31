package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses;


import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BuscarVagaEstacionamentoPorIdResponse {

    String id;

    String linhaEstacionamento;

    String colunaEstacionamento;

    public static BuscarVagaEstacionamentoPorIdResponse of(VagaEstacionamento vagaEstacionamento) {

        return new BuscarVagaEstacionamentoPorIdResponse(
                vagaEstacionamento.getId(),
                vagaEstacionamento.getLinhaEstacionamento(),
                vagaEstacionamento.getColunaEstacionamento());
    }
}
