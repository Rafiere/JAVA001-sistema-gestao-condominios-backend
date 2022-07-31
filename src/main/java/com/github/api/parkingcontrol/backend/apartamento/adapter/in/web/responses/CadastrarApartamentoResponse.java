package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.CadastrarMoradorResponse;
import lombok.Value;

@Value
public class CadastrarApartamentoResponse {

    String id;

    BlocoDoApartamento blocoDoApartamento;

    String numeroDoApartamento;

    public static CadastrarApartamentoResponse of(Apartamento apartamento){

        return new CadastrarApartamentoResponse(
                apartamento.getId(),
                apartamento.getBlocoDoApartamento(),
                apartamento.getNumeroDoApartamento());
    }
}
