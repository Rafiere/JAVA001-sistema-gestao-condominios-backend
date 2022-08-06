package com.github.api.parkingcontrol.backend.apartamento.domain.mappers;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApartamentoMapper {

    public Apartamento fromEntity(ApartamentoEntity apartamentoEntity){

        return new Apartamento(
                apartamentoEntity.getId(),
                apartamentoEntity.getBlocoDoApartamento(),
                apartamentoEntity.getNumeroDoApartamento());
    }

    public ApartamentoEntity fromDomain(Apartamento apartamento){

        return new ApartamentoEntity(
                UUID.randomUUID().toString(),
                apartamento.getBlocoDoApartamento(),
                apartamento.getNumeroDoApartamento());
    }

    public ApartamentoEntity fromDomainComIdPredefinido(Apartamento apartamento){

        return new ApartamentoEntity(
                apartamento.getId(),
                apartamento.getBlocoDoApartamento(),
                apartamento.getNumeroDoApartamento());
    }
}
