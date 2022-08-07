package com.github.api.parkingcontrol.backend.usuario.domain.entities;

import com.github.api.parkingcontrol.backend.usuario.domain.enums.TipoDeCargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private TipoDeCargo tipoDeCargo;

    @ElementCollection
    private List<String> idsUsuariosComOCargo;
}
