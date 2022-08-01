package com.github.api.parkingcontrol.backend.usuario.domain.entities;

import com.github.api.parkingcontrol.backend.usuario.domain.enums.TipoDeCargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private TipoDeCargo tipoDeCargo;
}
