package com.github.api.parkingcontrol.backend.estacionamento.domain.mappers;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VagaEstacionamentoMapper {

    public VagaEstacionamento fromEntity(VagaEstacionamentoEntity vagaEstacionamentoEntity) {

        return new VagaEstacionamento(
                vagaEstacionamentoEntity.getId(),
                vagaEstacionamentoEntity.getLinhaEstacionamento(),
                vagaEstacionamentoEntity.getColunaEstacionamento());
    }

    public VagaEstacionamentoEntity fromDomain(VagaEstacionamento vagaEstacionamento) {

        return new VagaEstacionamentoEntity(
                UUID.randomUUID().toString(),
                vagaEstacionamento.getLinhaEstacionamento(),
                vagaEstacionamento.getColunaEstacionamento());
    }

    public VagaEstacionamentoEntity fromDomainComIdPredefinido(VagaEstacionamento vagaEstacionamento) {

        return new VagaEstacionamentoEntity(
                vagaEstacionamento.getId(),
                vagaEstacionamento.getLinhaEstacionamento(),
                vagaEstacionamento.getColunaEstacionamento());
    }
}
