package com.github.api.parkingcontrol.backend.estacionamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagaEstacionamentoPorIdPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagasEstacionamentoPorIdsPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.CadastrarVagaEstacionamentoPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.RemoverVagaEstacionamentoPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import com.github.api.parkingcontrol.backend.estacionamento.domain.mappers.VagaEstacionamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VagaEstacionamentoPersistenceAdapter implements
        BuscarVagaEstacionamentoPorIdPort,
        CadastrarVagaEstacionamentoPort,
        BuscarVagasEstacionamentoPorIdsPort,
        RemoverVagaEstacionamentoPort {

    private final VagaEstacionamentoRepository vagaEstacionamentoRepository;
    private final VagaEstacionamentoMapper vagaEstacionamentoMapper;

    @Override
    public VagaEstacionamento buscarVagaEstacionamentoPorId(String id) {

        return vagaEstacionamentoRepository.findById(id)
                .map(vagaEstacionamentoMapper::fromEntity)
                .orElseThrow(() -> new BusinessRuleException("Não foi encontrada uma vaga de estacionamento " +
                        "com o ID " + id + "."));
    }

    @Override
    public List<VagaEstacionamento> buscarVagasEstacionamentoPorIds(List<String> vagasEstacionamentoId) {

        return vagaEstacionamentoRepository.findAllById(vagasEstacionamentoId)
                .stream()
                .map(vagaEstacionamentoMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void removerVagaEstacionamento(String idVagaEstacionamento) {

        vagaEstacionamentoRepository.deleteById(idVagaEstacionamento);
    }

    @Override
    public VagaEstacionamento cadastrarVagaEstacionamento(VagaEstacionamento vagaEstacionamento) {

        VagaEstacionamentoEntity vagaEstacionamentoEntity =
                vagaEstacionamentoMapper.fromDomain(vagaEstacionamento);

        vagaEstacionamentoRepository.save(vagaEstacionamentoEntity);

        return vagaEstacionamentoMapper.fromEntity(vagaEstacionamentoEntity);
    }
}
