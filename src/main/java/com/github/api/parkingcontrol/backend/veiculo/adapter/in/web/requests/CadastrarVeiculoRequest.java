package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CadastrarVeiculoRequest {

    @NotBlank
    String placaDoVeiculo;

    @NotBlank
    String marcaDoVeiculo;

    @NotBlank
    String modeloDoVeiculo;

    @NotBlank
    String corDoVeiculo;
}
