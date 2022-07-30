package com.github.api.parkingcontrol.backend.apartamento.domain.entities;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApartamentoEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private BlocoDoApartamento blocoDoApartamento;

    private String numeroDoApartamento;
}
