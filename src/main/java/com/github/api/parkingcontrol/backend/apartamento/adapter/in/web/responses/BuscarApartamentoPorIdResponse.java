package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.Value;

@Value
public class BuscarApartamentoPorIdResponse {

    String id;

    String numeroDoApartamento;

    BlocoDoApartamento blocoDoApartamento;

    public static BuscarApartamentoPorIdResponse of(Apartamento apartamento) {
        return new BuscarApartamentoPorIdResponse(
                apartamento.getId(),
                apartamento.getNumeroDoApartamento(),
                apartamento.getBlocoDoApartamento()
        );
    }
}
