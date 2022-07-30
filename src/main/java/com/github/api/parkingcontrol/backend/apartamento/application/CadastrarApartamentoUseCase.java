package com.github.api.parkingcontrol.backend.apartamento.application;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.CadastrarApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.CadastrarApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.morador.application.port.out.BuscarMoradorPorIdPort;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarApartamentoUseCase {

    private final CadastrarApartamentoPort cadastrarApartamentoPort;

    public Apartamento execute(CadastrarApartamentoCommand command) {

        Apartamento novoApartamento = new Apartamento(
                command.getBlocoDoApartamento(),
                command.getNumeroDoApartamento());

        return cadastrarApartamentoPort.cadastrarApartamento(novoApartamento);
    }
}
