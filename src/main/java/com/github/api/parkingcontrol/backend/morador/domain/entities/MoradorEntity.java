package com.github.api.parkingcontrol.backend.morador.domain.entities;

import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
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
public class MoradorEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    private String nome;

    private String sobrenome;

    private String cpf;

    @OneToMany
    private List<ApartamentoEntity> apartamentos;

    @OneToMany
    private List<VeiculoEntity> veiculos;

    @OneToMany
    private List<VagaEstacionamentoEntity> vagasEstacionamento;
}
