package com.github.api.parkingcontrol.backend.morador.application;

import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentosPorIdsPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagasEstacionamentoPorIdsPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.EditarMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.application.port.out.BuscarMoradorPorIdPort;
import com.github.api.parkingcontrol.backend.morador.application.port.out.CadastrarMoradorPort;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculosPorIdsPort;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditarMoradorUseCase {

    private final CadastrarMoradorPort cadastrarMoradorPort;
    private final BuscarApartamentosPorIdsPort buscarApartamentosPorIdsPort;
    private final BuscarVeiculosPorIdsPort buscarVeiculosPorIdsPort;
    private final BuscarVagasEstacionamentoPorIdsPort buscarVagasEstacionamentoPorIdsPort;
    private final BuscarMoradorPorIdPort buscarMoradorPorIdPort;

    public Morador execute(EditarMoradorCommand command) {

        Morador morador = buscarMoradorPorIdPort.buscarMoradorPorId(command.getIdMorador());

        List<Apartamento> apartamentosDoMorador =
                buscarApartamentosPorIdsPort.buscarApartamentosPorId(command.getApartamentosIds());

        List<Veiculo> veiculosDoMorador =
                buscarVeiculosPorIdsPort.buscarVeiculosPorIds(command.getVeiculosIds());

        List<VagaEstacionamento> vagasEstacionamentoDoMorador =
                buscarVagasEstacionamentoPorIdsPort.buscarVagasEstacionamentoPorIds(command.getVagasEstacionamentoId());

        morador.atualizar(
                command.getNome(),
                command.getSobrenome(),
                command.getCpf(),
                apartamentosDoMorador,
                veiculosDoMorador,
                vagasEstacionamentoDoMorador);

        return cadastrarMoradorPort.cadastrarMorador(morador);
    }
}
