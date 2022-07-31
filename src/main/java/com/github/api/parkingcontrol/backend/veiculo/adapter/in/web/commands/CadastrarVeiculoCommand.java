package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands;

import lombok.Value;

@Value
public class CadastrarVeiculoCommand {

    String placaDoVeiculo;

    String marcaDoVeiculo;

    String modeloDoVeiculo;

    String corDoVeiculo;
}
