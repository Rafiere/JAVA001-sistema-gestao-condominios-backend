package com.github.api.parkingcontrol.backend.morador.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.morador.application.port.out.*;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import com.github.api.parkingcontrol.backend.morador.domain.mappers.MoradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MoradorPersistenceAdapter implements
        CadastrarMoradorPort,
        CadastrarVariosMoradoresPort,
        ExcluirMoradorPort,
        BuscarMoradorPorIdPort,
        BuscarMoradorPeloNomeCompletoPort {

    private final MoradorRepository moradorRepository;
    private final MoradorMapper moradorMapper;

    @Override
    public List<Morador> buscarMoradorPeloNomeCompleto(String nomeCompletoMorador) {

        //TODO: Testar query.
        return moradorRepository.buscarPeloNomeCompleto(nomeCompletoMorador)
                .stream()
                .map(moradorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Morador buscarMoradorPorId(String idMorador) {

        return moradorRepository.findById(idMorador).map(moradorMapper::fromEntity)
                .orElseThrow(() -> new BusinessRuleException(
                        "Não existe nenhum morador com o ID " + idMorador + " cadastrado no banco de dados!"));
    }

    @Override
    public Morador cadastrarMorador(Morador morador) {

        MoradorEntity moradorEntity = moradorMapper.fromDomain(morador);

        moradorRepository.save(moradorEntity);

        return moradorMapper.fromEntity(moradorEntity);
    }

    @Override
    public List<Morador> cadastrarVariosMoradores(List<Morador> moradores) {

        List<MoradorEntity> moradorEntities = moradores
                .stream()
                .map(moradorMapper::fromDomain)
                .collect(Collectors.toList());

        moradorRepository.saveAll(moradorEntities);

        return moradorEntities
                .stream()
                .map(moradorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void excluirMorador(String idMorador) {

        moradorRepository.deleteById(idMorador);
    }
}
