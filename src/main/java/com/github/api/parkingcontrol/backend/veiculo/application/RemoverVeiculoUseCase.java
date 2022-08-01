package com.github.api.parkingcontrol.backend.veiculo.application;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.RemoverVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.RemoverVeiculoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RemoverVeiculoUseCase {

    private final RemoverVeiculoPort removerVeiculoPort;

    public void execute(RemoverVeiculoCommand command) {

        removerVeiculoPort.removerVeiculo(command.getIdVeiculo());
    }
}
