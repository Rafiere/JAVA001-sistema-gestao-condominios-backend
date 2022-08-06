package com.github.api.parkingcontrol.backend.estacionamento.domain.entities;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VagaEstacionamentoEntity {

    @Id
    private String id;

    private String linhaEstacionamento;

    private String colunaEstacionamento;
}
