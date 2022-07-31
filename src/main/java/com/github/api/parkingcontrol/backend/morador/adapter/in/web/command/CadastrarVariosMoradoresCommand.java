package com.github.api.parkingcontrol.backend.morador.adapter.in.web.command;

import lombok.Value;

import java.util.List;

@Value
public class CadastrarVariosMoradoresCommand {

    List<CadastrarMoradorCommand> commands;
}
