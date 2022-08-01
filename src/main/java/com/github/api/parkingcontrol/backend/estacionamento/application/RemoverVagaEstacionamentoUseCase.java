package com.github.api.parkingcontrol.backend.estacionamento.application;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.RemoverVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.RemoverVagaEstacionamentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RemoverVagaEstacionamentoUseCase {

    private final RemoverVagaEstacionamentoPort removerVagaEstacionamentoPort;

    public void execute(RemoverVagaEstacionamentoCommand command) {

        removerVagaEstacionamentoPort.removerVagaEstacionamento(command.getIdVagaEstacionamento());
    }
}
