package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class EditarVagaEstacionamentoCommand {

    String idVagaEstacionamento;

    String linhaEstacionamento;

    String colunaEstacionamento;
}
