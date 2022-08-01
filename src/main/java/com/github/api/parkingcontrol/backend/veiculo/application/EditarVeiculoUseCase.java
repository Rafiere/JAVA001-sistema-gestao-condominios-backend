package com.github.api.parkingcontrol.backend.veiculo.application;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.EditarVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculoPeloIdPort;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.CadastrarVeiculoPort;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EditarVeiculoUseCase {

    private final CadastrarVeiculoPort cadastrarVeiculoPort;
    private final BuscarVeiculoPeloIdPort buscarVeiculoPeloIdPort;

    public Veiculo execute(EditarVeiculoCommand command) {

        Veiculo veiculo = buscarVeiculoPeloIdPort.buscarVeiculoPeloId(command.getId());

        veiculo.atualizar(command.getPlacaDoVeiculo(),
                command.getMarcaDoVeiculo(),
                command.getModeloDoVeiculo(),
                command.getCorDoVeiculo());

        return cadastrarVeiculoPort.cadastrarVeiculo(veiculo);
    }
}
