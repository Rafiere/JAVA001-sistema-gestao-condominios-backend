package com.github.api.parkingcontrol.backend.veiculo.domain.mappers;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public Veiculo fromEntity(VeiculoEntity veiculoEntity){

        return new Veiculo(
                veiculoEntity.getId(),
                veiculoEntity.getPlacaDoVeiculo(),
                veiculoEntity.getMarcaDoVeiculo(),
                veiculoEntity.getModeloDoVeiculo(),
                veiculoEntity.getCorDoVeiculo());
    }

    public VeiculoEntity fromDomain(Veiculo veiculo){

        return new VeiculoEntity(
                veiculo.getPlacaDoVeiculo(),
                veiculo.getMarcaDoVeiculo(),
                veiculo.getModeloDoVeiculo(),
                veiculo.getCorDoVeiculo());
    }
}
