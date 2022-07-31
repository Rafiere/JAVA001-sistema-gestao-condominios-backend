package com.github.api.parkingcontrol.backend.estacionamento.domain;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VagaEstacionamento {

    private String id;

    private String linhaEstacionamento;

    private String colunaEstacionamento;

    public VagaEstacionamento(String linhaEstacionamento, String colunaEstacionamento) {
        this.linhaEstacionamento = linhaEstacionamento;
        this.colunaEstacionamento = colunaEstacionamento;
    }

    public void atualizar(String linhaEstacionamento, String colunaEstacionamento) {

        this.linhaEstacionamento = linhaEstacionamento;
        this.colunaEstacionamento = colunaEstacionamento;
    }
}
