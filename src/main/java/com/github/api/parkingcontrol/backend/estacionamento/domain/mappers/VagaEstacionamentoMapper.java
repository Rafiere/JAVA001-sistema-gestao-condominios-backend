package com.github.api.parkingcontrol.backend.estacionamento.domain.mappers;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class VagaEstacionamentoMapper {

    public VagaEstacionamento fromEntity(VagaEstacionamentoEntity vagaEstacionamentoEntity){

        return new VagaEstacionamento(
                vagaEstacionamentoEntity.getId(),
                vagaEstacionamentoEntity.getLinhaEstacionamento(),
                vagaEstacionamentoEntity.getColunaEstacionamento());
    }

    public VagaEstacionamentoEntity fromDomain(VagaEstacionamento vagaEstacionamento){

        return new VagaEstacionamentoEntity(
            vagaEstacionamento.getLinhaEstacionamento(),
            vagaEstacionamento.getColunaEstacionamento());
    }

}
