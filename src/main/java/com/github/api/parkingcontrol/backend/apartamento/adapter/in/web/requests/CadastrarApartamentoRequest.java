package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.requests;

import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CadastrarApartamentoRequest {

    @NotBlank
    String numeroDoApartamento;

    @NotBlank
    BlocoDoApartamento blocoDoApartamento;
}
