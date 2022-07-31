package com.github.api.parkingcontrol.backend.veiculo.application;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.CadastrarVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.CadastrarVeiculoPort;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarVeiculoUseCase {

    private final CadastrarVeiculoPort cadastrarVeiculoPort;

    public Veiculo execute(CadastrarVeiculoCommand command) {

        Veiculo veiculo = new Veiculo(
                command.getPlacaDoVeiculo(),
                command.getMarcaDoVeiculo(),
                command.getModeloDoVeiculo(),
                command.getCorDoVeiculo());

        return cadastrarVeiculoPort.cadastrarVeiculo(veiculo);
    }
}
