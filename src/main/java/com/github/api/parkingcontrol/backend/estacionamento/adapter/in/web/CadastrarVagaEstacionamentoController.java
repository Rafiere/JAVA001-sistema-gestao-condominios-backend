package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.CadastrarVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.requests.CadastrarVagaEstacionamentoRequest;
import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses.CadastrarVagaEstacionamentoResponse;
import com.github.api.parkingcontrol.backend.estacionamento.application.CadastrarVagaEstacionamentoUseCase;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/vaga-estacionamento")
@RequiredArgsConstructor
public class CadastrarVagaEstacionamentoController {

    private final CadastrarVagaEstacionamentoUseCase cadastrarVagaEstacionamentoUseCase;

    @PostMapping("/cadastrar-vaga-estacionamento")
    public ResponseEntity<CadastrarVagaEstacionamentoResponse> execute(@RequestBody @Valid CadastrarVagaEstacionamentoRequest request) { //O @Valid fará com que as validações da request sejam realizadas.

        CadastrarVagaEstacionamentoCommand command = new CadastrarVagaEstacionamentoCommand(
                request.getLinhaEstacionamento(),
                request.getColunaEstacionamento());

        VagaEstacionamento vagaEstacionamento = cadastrarVagaEstacionamentoUseCase.execute(command);

        return ResponseEntity.status(201).body(CadastrarVagaEstacionamentoResponse.of(vagaEstacionamento));
    }
}