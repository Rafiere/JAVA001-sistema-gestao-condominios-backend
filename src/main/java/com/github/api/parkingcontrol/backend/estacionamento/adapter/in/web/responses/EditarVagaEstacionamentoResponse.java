package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.Value;

@Value
public class EditarVagaEstacionamentoResponse {

    String id;

    String linhaEstacionamento;

    String colunaEstacionamento;

    public static EditarVagaEstacionamentoResponse of(VagaEstacionamento vagaEstacionamento){

        return new EditarVagaEstacionamentoResponse(
                vagaEstacionamento.getId(),
                vagaEstacionamento.getLinhaEstacionamento(),
                vagaEstacionamento.getColunaEstacionamento());
    }
}
