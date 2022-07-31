package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands;

import lombok.Value;

@Value
public class EditarVeiculoCommand {

    String id;

    String placaDoVeiculo;

    String marcaDoVeiculo;

    String modeloDoVeiculo;

    String corDoVeiculo;
}
