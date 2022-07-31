package com.github.api.parkingcontrol.backend.morador.domain;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Morador {

    private String id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private List<Apartamento> apartamentos;

    private List<Veiculo> veiculos;

    private List<VagaEstacionamento> vagasEstacionamento;


    public Morador(String nome,
                   String sobrenome,
                   String cpf,
                   List<Apartamento> apartamentos,
                   List<Veiculo> veiculos,
                   List<VagaEstacionamento> vagasEstacionamento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.apartamentos = apartamentos;
        this.veiculos = veiculos;
        this.vagasEstacionamento = vagasEstacionamento;
    }

    public String obterNomeCompleto(){

        return this.nome + " " + this.sobrenome;
    }

    public void atualizar(String nome,
                          String sobrenome,
                          String cpf,
                          List<Apartamento> apartamentosDoMorador,
                          List<Veiculo> veiculosDoMorador,
                          List<VagaEstacionamento> vagasEstacionamentoDoMorador) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.apartamentos = apartamentosDoMorador;
        this.veiculos = veiculosDoMorador;
        this.vagasEstacionamento = vagasEstacionamentoDoMorador;
    }
}
