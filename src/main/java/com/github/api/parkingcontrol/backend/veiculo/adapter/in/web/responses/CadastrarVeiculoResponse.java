package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.CadastrarMoradorResponse;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class CadastrarVeiculoResponse {

    String id;

    String placaDoVeiculo;

    String marcaDoVeiculo;

    String modeloDoVeiculo;

    String corDoVeiculo;

    public static CadastrarVeiculoResponse of(Veiculo veiculoCadastrado) {

        return new CadastrarVeiculoResponse(
                veiculoCadastrado.getId(),
                veiculoCadastrado.getPlacaDoVeiculo(),
                veiculoCadastrado.getMarcaDoVeiculo(),
                veiculoCadastrado.getModeloDoVeiculo(),
                veiculoCadastrado.getCorDoVeiculo());
    }
}
