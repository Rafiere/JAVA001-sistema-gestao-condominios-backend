package com.github.api.parkingcontrol.backend.usuario.domain.mappers;

import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.CargoEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CargoMapper {

    private final UsuarioMapper usuarioMapper;

    public CargoMapper(@Lazy UsuarioMapper usuarioMapper) { //Inserção do "@Lazy" para retirar a dependência circular entre os mappers.
        this.usuarioMapper = usuarioMapper;
    }

    public Cargo fromEntity(CargoEntity cargoEntity){

        return new Cargo(
                cargoEntity.getId(),
                cargoEntity.getTipoDeCargo(),
                cargoEntity.getUsuarios().stream().map(usuarioMapper::fromEntity).collect(Collectors.toList()));
    }

    public CargoEntity fromDomain(Cargo cargo){

        return new CargoEntity(
                UUID.randomUUID().toString(),
                cargo.getCargo(),
                cargo.getUsuarios().stream().map(usuarioMapper::fromDomain).collect(Collectors.toList()));
    }

    public CargoEntity fromDomainComIdPredefinido(Cargo cargo){

        return new CargoEntity(
                cargo.getId(),
                cargo.getCargo(),
                cargo.getUsuarios().stream().map(usuarioMapper::fromDomainComIdPredefinido).collect(Collectors.toList()));
    }
}
