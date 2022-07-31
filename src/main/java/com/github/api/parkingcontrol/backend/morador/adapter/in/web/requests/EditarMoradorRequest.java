package com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value
public class EditarMoradorRequest {

    @NotBlank
    String nome;

    @NotBlank
    String sobrenome;

    @NotBlank
    String cpf;

    @NotBlank
    List<String> apartamentosIds;

    @NotBlank
    List<String> veiculosIds;

    @NotBlank
    List<String> vagasEstacionamentoId;
}