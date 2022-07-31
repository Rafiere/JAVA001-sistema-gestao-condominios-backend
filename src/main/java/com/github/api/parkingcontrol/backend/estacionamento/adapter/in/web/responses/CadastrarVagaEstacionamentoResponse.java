package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CadastrarVagaEstacionamentoResponse {

    String id;

    String linhaEstacionamento;

    String colunaEstacionamento;

    public static CadastrarVagaEstacionamentoResponse of(VagaEstacionamento vagaEstacionamento){

        return new CadastrarVagaEstacionamentoResponse(
                vagaEstacionamento.getId(),
                vagaEstacionamento.getLinhaEstacionamento(),
                vagaEstacionamento.getColunaEstacionamento());
    }
}
