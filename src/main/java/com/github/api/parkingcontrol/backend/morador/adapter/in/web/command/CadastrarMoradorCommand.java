package com.github.api.parkingcontrol.backend.morador.adapter.in.web.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class CadastrarMoradorCommand {

    String nome;

    String sobrenome;

    String cpf;

    List<String> apartamentosIds;

    List<String> veiculosIds;

    List<String> vagasEstacionamentoId;
}
