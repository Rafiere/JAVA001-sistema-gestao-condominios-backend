package com.github.api.parkingcontrol.backend.apartamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentoPorIdPort;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.CadastrarApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.RemoverApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.VerificarSeExisteMoradorNoApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import com.github.api.parkingcontrol.backend.apartamento.domain.mappers.ApartamentoMapper;
import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApartamentoPersistenceAdapter implements
        BuscarApartamentoPorIdPort,
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
