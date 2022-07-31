package com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class CadastrarVariosMoradoresRequest {

    @NotBlank
    List<CadastrarMoradorRequest> moradores;
}
