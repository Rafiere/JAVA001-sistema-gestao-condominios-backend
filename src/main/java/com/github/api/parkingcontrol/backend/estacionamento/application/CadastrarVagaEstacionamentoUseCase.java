package com.github.api.parkingcontrol.backend.estacionamento.application;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.CadastrarVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.CadastrarVagaEstacionamentoPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.CadastrarVeiculoPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CadastrarVagaEstacionamentoUseCase {

    private final CadastrarVagaEstacionamentoPort cadastrarVagaEstacionamentoPort;

    public VagaEstacionamento execute(CadastrarVagaEstacionamentoCommand command) {

        VagaEstacionamento vagaEstacionamento = new VagaEstacionamento(
                command.getLinhaEstacionamento(),
                command.getColunaEstacionamento());

        return cadastrarVagaEstacionamentoPort.cadastrarVagaEstacionamento(vagaEstacionamento);
    }
}
