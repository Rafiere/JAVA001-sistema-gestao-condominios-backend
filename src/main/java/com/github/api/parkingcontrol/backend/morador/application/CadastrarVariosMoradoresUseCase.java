package com.github.api.parkingcontrol.backend.morador.application;

import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentosPorIdsPort;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagasEstacionamentoPorIdsPort;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.CadastrarVariosMoradoresCommand;
import com.github.api.parkingcontrol.backend.morador.application.port.out.CadastrarVariosMoradoresPort;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculosPorIdsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CadastrarVariosMoradoresUseCase {

    private final BuscarApartamentosPorIdsPort buscarApartamentosPorIdPort;
    private final BuscarVeiculosPorIdsPort buscarVeiculosPorIdsPort;
    private final BuscarVagasEstacionamentoPorIdsPort buscarVagasEstacionamentoPorIdsPort;
    private final CadastrarVariosMoradoresPort cadastrarVariosMoradoresPort;

    public List<Morador> execute(CadastrarVariosMoradoresCommand command) {

        List<Morador> moradoresCriados = command.getCommands()
                .stream()
                .map(commandMorador -> new Morador(
                        commandMorador.getNome(),
                        commandMorador.getSobrenome(),
                        commandMorador.getCpf(),
                        buscarApartamentosPorIdPort.buscarApartamentosPorId(commandMorador.getApartamentosIds()),
                        buscarVeiculosPorIdsPort.buscarVeiculosPorIds(commandMorador.getVeiculosIds()),
                        buscarVagasEstacionamentoPorIdsPort.buscarVagasEstacionamentoPorIds(commandMorador.getVagasEstacionamentoId())))
                .collect(Collectors.toList());

        return cadastrarVariosMoradoresPort.cadastrarVariosMoradores(moradoresCriados);
    }
}
