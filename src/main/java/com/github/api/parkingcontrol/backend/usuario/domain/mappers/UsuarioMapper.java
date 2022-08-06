package com.github.api.parkingcontrol.backend.usuario.domain.mappers;

import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final CargoMapper cargoMapper;

    public Usuario fromEntity(UsuarioEntity usuarioEntity) {

        return new Usuario(
                usuarioEntity.getId(),
                usuarioEntity.getEmail(),
                usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                usuarioEntity.isAtivo(),
                usuarioEntity.getCargos().stream().map(cargoMapper::fromEntity).collect(Collectors.toList()));
    }

    public UsuarioEntity fromDomain(Usuario usuario) {

        return new UsuarioEntity(
                UUID.randomUUID().toString(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getCargos().stream().map(cargoMapper::fromDomain).collect(Collectors.toList()));
    }

    public UsuarioEntity fromDomainComIdPredefinido(Usuario usuario){

        return new UsuarioEntity(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getCargos().stream().map(cargoMapper::fromDomainComIdPredefinido).collect(Collectors.toList()));
    }
}
