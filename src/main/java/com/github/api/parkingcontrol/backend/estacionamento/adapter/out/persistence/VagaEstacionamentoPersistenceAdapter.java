package com.github.api.parkingcontrol.backend.estacionamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagaEstacionamentoPorIdPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.CadastrarVagaEstacionamentoPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VagaEstacionamentoPersistenceAdapter implements
        BuscarVagaEstacionamentoPorIdPort,
        CadastrarVagaEstacionamentoPort {

    private final VagaEstacionamentoRepository vagaEstacionamentoRepository;

    @Override
    public VagaEstacionamento buscarVagaEstacionamentoPorId(String id) {

        return vagaEstacionamentoRepository.findById(id)
                .map(vagaEstacionamentoEntity -> vagaEstacionamentoEntity.toVagaEstacionamento(vagaEstacionamentoEntity))
                .orElseThrow(() -> new BusinessRuleException("Não foi encontrada uma vaga com o ID especificado."));
    }

    @Override
    public void cadastrarVagaEstacionamentoPort(VagaEstacionamentoEntity vagaEstacionamento) {

        vagaEstacionamentoRepository.save(vagaEstacionamento);
    }
}
