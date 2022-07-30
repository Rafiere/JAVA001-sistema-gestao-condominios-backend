package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import lombok.Value;

@Value
public class EditarApartamentoResponse {

    String idApartamento;

    String numeroDoApartamento;

    BlocoDoApartamento blocoDoApartamento;

    public static EditarApartamentoResponse of(Apartamento apartamento) {
        return new EditarApartamentoResponse(
                apartamento.getId(),
                apartamento.getNumeroDoApartamento(),
                apartamento.getBlocoDoApartamento()
        );
    }
}
