package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;

/**
 * Dentro dessa classe devemos inserir todas as validações relacionadas aos
 * campos da aplicação.
 */

@Value
public class CadastrarVagaEstacionamentoRequest {

    @NotBlank
    String linhaEstacionamento;

    @NotBlank
    String colunaEstacionamento;
}
