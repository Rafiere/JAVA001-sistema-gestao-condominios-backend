package com.github.api.parkingcontrol.backend.usuario.domain.mappers;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.CargoEntity;
import org.springframework.stereotype.Component;

@Component
public class CargoMapper {

    public Cargo fromEntity(CargoEntity cargoEntity){

        return new Cargo(
                cargoEntity.getId(),
                cargoEntity.getTipoDeCargo());
    }

    public CargoEntity fromDomain(Cargo cargo){

        return new CargoEntity(
                cargo.getCargo());
    }
}
