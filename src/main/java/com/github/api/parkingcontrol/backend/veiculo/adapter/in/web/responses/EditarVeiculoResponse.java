package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class EditarVeiculoResponse {

    String id;

    String placaDoVeiculo;

    String marcaDoVeiculo;

    String modeloDoVeiculo;

    String corDoVeiculo;

    public static EditarVeiculoResponse of(Veiculo veiculo){

        return new EditarVeiculoResponse(
                veiculo.getId(),
                veiculo.getPlacaDoVeiculo(),
                veiculo.getMarcaDoVeiculo(),
                veiculo.getModeloDoVeiculo(),
                veiculo.getCorDoVeiculo());
    }
}
