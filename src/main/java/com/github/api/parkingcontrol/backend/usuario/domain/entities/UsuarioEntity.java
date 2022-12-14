package com.github.api.parkingcontrol.backend.usuario.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsuarioEntity {

    @Id
    private String id;

    private String email;

    private String username;

    private String password;

    private boolean isAtivo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(joinColumns = @JoinColumn(name = "usuario_id"),
               inverseJoinColumns = @JoinColumn(name = "cargo_id"))
    private List<CargoEntity> cargos;
}
