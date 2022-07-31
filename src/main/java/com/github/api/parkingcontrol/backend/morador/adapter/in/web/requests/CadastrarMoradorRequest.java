package com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class CadastrarMoradorRequest {

    @NotBlank
    String nome;

    @NotBlank
    String sobrenome;

    @NotBlank
    String cpf;

    @NotBlank
    List<String> apartamentosIds;

    List<String> veiculosIds;

    List<String> vagasEstacionamentoId;
}
