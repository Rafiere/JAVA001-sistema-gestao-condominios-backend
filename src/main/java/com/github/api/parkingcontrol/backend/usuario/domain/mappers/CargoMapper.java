package com.github.api.parkingcontrol.backend.usuario.domain.mappers;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.CargoEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CargoMapper {

    public Cargo fromEntity(CargoEntity cargoEntity){

        return new Cargo(
                cargoEntity.getId(),
                cargoEntity.getTipoDeCargo(),
                cargoEntity.getIdsUsuariosComOCargo());
    }

    public CargoEntity fromDomain(Cargo cargo){

        return new CargoEntity(
                UUID.randomUUID().toString(),
                cargo.getCargo(),
                cargo.getIdsUsuariosComEsseCargo());
    }

    public CargoEntity fromDomainComIdPredefinido(Cargo cargo){

        return new CargoEntity(
                cargo.getId(),
                cargo.getCargo(),
                cargo.getIdsUsuariosComEsseCargo());
    }
}
