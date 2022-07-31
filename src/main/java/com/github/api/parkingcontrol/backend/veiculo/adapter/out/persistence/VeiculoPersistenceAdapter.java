package com.github.api.parkingcontrol.backend.veiculo.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculoPeloIdPort;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculosPorIdsPort;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.CadastrarVeiculoPort;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.RemoverVeiculoPort;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.mappers.VeiculoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VeiculoPersistenceAdapter implements
        CadastrarVeiculoPort,
        BuscarVeiculosPorIdsPort,
        BuscarVeiculoPeloIdPort,
        RemoverVeiculoPort {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    @Override
    public List<Veiculo> buscarVeiculosPorIds(List<String> idsVeiculos) {

        return veiculoRepository.findAllById(idsVeiculos)
                .stream()
                .map(veiculoMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Veiculo buscarVeiculoPeloId(String idVeiculo) {

        return veiculoRepository.findById(idVeiculo)
                .map(veiculoMapper::fromEntity)
                .orElseThrow(() -> new BusinessRuleException("O veículo como ID " + idVeiculo + " não foi encontrado!"));
    }

    @Override
    public void removerVeiculo(String idVeiculo) {

        veiculoRepository.deleteById(idVeiculo);
    }

    @Override
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {

        VeiculoEntity veiculoEntity = veiculoMapper.fromDomain(veiculo);

        veiculoRepository.save(veiculoEntity);

        return veiculoMapper.fromEntity(veiculoEntity);
    }
}
