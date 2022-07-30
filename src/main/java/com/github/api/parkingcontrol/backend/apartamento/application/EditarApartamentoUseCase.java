package com.github.api.parkingcontrol.backend.apartamento.application;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.EditarApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentoPorIdPort;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.CadastrarApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditarApartamentoUseCase {

    private final BuscarApartamentoPorIdPort buscarApartamentoPorIdPort;

    private final CadastrarApartamentoPort cadastrarApartamentoPort;

    public Apartamento execute(EditarApartamentoCommand command) {

        Apartamento apartamento = buscarApartamentoPorIdPort.buscarApartamentoPorId(command.getIdApartamento());

        apartamento.atualizar(
                command.getBlocoDoApartamento(),
                command.getNumeroDoApartamento());

        return cadastrarApartamentoPort.cadastrarApartamento(apartamento);
    }
}
