package com.github.api.parkingcontrol.backend.estacionamento.application;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.EditarVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagaEstacionamentoPorIdPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.CadastrarVagaEstacionamentoPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EditarVagaEstacionamentoUseCase {

    private final CadastrarVagaEstacionamentoPort cadastrarVagaEstacionamentoPort;
    private final BuscarVagaEstacionamentoPorIdPort buscarVagaEstacionamentoPorIdPort;

    public VagaEstacionamento execute(EditarVagaEstacionamentoCommand command) {

        VagaEstacionamento vagaEstacionamento
                = buscarVagaEstacionamentoPorIdPort.buscarVagaEstacionamentoPorId(command.getIdVagaEstacionamento());

        vagaEstacionamento.atualizar(
                command.getLinhaEstacionamento(),
                command.getColunaEstacionamento());

        return cadastrarVagaEstacionamentoPort.cadastrarVagaEstacionamento(vagaEstacionamento);
    }
}
