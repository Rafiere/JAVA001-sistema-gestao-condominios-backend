package com.github.api.parkingcontrol.backend.veiculo.domain.entities;

import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VeiculoEntity {

    @Id
    private String id;

    private String placaDoVeiculo;

    private String marcaDoVeiculo;

    private String modeloDoVeiculo;

    private String corDoVeiculo;
}
