package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class EditarVagaEstacionamentoRequest {

    @NotBlank
    String linhaEstacionamento;

    @NotBlank
    String colunaEstacionamento;
}
