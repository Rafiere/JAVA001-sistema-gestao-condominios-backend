package com.github.api.parkingcontrol.backend.veiculo.domain.mappers;

import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
                UUID.randomUUID().toString(),
                veiculo.getPlacaDoVeiculo(),
                veiculo.getMarcaDoVeiculo(),
                veiculo.getModeloDoVeiculo(),
                veiculo.getCorDoVeiculo());
    }

    public VeiculoEntity fromDomainComIdPredefinido(Veiculo veiculo){

        return new VeiculoEntity(
                veiculo.getId(),
                veiculo.getPlacaDoVeiculo(),
                veiculo.getMarcaDoVeiculo(),
                veiculo.getModeloDoVeiculo(),
                veiculo.getCorDoVeiculo());
    }
}
