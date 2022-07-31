package com.github.api.parkingcontrol.backend.apartamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.apartamento.application.port.out.*;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import com.github.api.parkingcontrol.backend.apartamento.domain.mappers.ApartamentoMapper;
import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApartamentoPersistenceAdapter implements
        BuscarApartamentoPorIdPort,
        BuscarApartamentosPorIdsPort,
        CadastrarApartamentoPort,
        RemoverApartamentoPort,
        VerificarSeExisteMoradorNoApartamentoPort {

    private final ApartamentoRepository apartamentoRepository;
    private final ApartamentoMapper apartamentoMapper;

    @Override
    public Apartamento buscarApartamentoPorId(String id) {

        return apartamentoRepository.findById(id)
                .stream()
                .map(apartamentoMapper::fromEntity)
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Nenhum apartamento com o ID " + id + " foi encontrado!"));
    }

    @Override
    public List<Apartamento> buscarApartamentosPorId(List<String> idsApartamentos) {

        return apartamentoRepository.findAllById(idsApartamentos)
                .stream()
                .map(apartamentoMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Apartamento cadastrarApartamento(Apartamento apartamento) {

        ApartamentoEntity apartamentoEntity = apartamentoMapper.fromDomain(apartamento);

        apartamentoRepository.save(apartamentoEntity);

        return apartamentoMapper.fromEntity(apartamentoEntity);
    }

    @Override
    public void removerApartamento(String idApartamento) {

        apartamentoRepository.deleteById(idApartamento);
    }

    @Override
    public boolean verificarSeExisteMoradorNoApartamento(String idApartamento) {

        return apartamentoRepository.verificarSeExisteMoradorNoApartamento(idApartamento);
    }
}
