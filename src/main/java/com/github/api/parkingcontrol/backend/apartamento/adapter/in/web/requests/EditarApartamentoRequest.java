package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.requests;

import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class EditarApartamentoRequest {

    @NotBlank
    String numeroDoApartamento;

    @NotBlank
    BlocoDoApartamento blocoDoApartamento;
}
