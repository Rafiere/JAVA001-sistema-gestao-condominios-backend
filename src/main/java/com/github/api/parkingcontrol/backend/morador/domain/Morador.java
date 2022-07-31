package com.github.api.parkingcontrol.backend.morador.domain;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Morador {

    private String id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private List<Apartamento> apartamento;

    private List<Veiculo> veiculos;

    private List<VagaEstacionamento> vagasEstacionamento;

    public String obterNomeCompleto(){

        return this.nome + " " + this.sobrenome;
    }
}
