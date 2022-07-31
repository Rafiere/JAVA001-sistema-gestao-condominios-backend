package com.github.api.parkingcontrol.backend.morador.domain.mappers;

import com.github.api.parkingcontrol.backend.apartamento.domain.mappers.ApartamentoMapper;
import com.github.api.parkingcontrol.backend.estacionamento.domain.mappers.VagaEstacionamentoMapper;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.mappers.VeiculoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MoradorMapper {
    private final ApartamentoMapper apartamentoMapper;
    private final VeiculoMapper veiculoMapper;
    private final VagaEstacionamentoMapper vagaEstacionamentoMapper;

    public Morador fromEntity(MoradorEntity moradorEntity){

        return new Morador(
                moradorEntity.getId(),
                moradorEntity.getNome(),
                moradorEntity.getSobrenome(),
                moradorEntity.getCpf(),
                moradorEntity.getApartamentos().stream().map(apartamentoMapper::fromEntity).collect(Collectors.toList()),
                moradorEntity.getVeiculos().stream().map(veiculoMapper::fromEntity).collect(Collectors.toList()),
                moradorEntity.getVagasEstacionamento().stream().map(vagaEstacionamentoMapper::fromEntity).collect(Collectors.toList()));
    }

    public MoradorEntity fromDomain(Morador morador){

        return new MoradorEntity(
                morador.getNome(),
                morador.getSobrenome(),
                morador.getCpf(),
                morador.getApartamentos().stream().map(apartamentoMapper::fromDomain).collect(Collectors.toList()),
                morador.getVeiculos().stream().map(veiculoMapper::fromDomain).collect(Collectors.toList()),
                morador.getVagasEstacionamento().stream().map(vagaEstacionamentoMapper::fromDomain).collect(Collectors.toList())
        );
    }



}
