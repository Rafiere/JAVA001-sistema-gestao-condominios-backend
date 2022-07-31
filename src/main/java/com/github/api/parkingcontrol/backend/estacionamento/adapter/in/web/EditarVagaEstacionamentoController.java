package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.EditarVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.requests.EditarVagaEstacionamentoRequest;
import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses.EditarVagaEstacionamentoResponse;
import com.github.api.parkingcontrol.backend.estacionamento.application.EditarVagaEstacionamentoUseCase;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/vaga-estacionamento")
@RequiredArgsConstructor
public class EditarVagaEstacionamentoController {

    private final EditarVagaEstacionamentoUseCase editarVagaEstacionamentoUseCase;

    @PutMapping("/editar-vaga-estacionamento")
    public ResponseEntity<EditarVagaEstacionamentoResponse> execute(@RequestParam String idVagaEstacionamento,
                                                                    @RequestBody @Valid EditarVagaEstacionamentoRequest request) {

        EditarVagaEstacionamentoCommand command = new EditarVagaEstacionamentoCommand(
                idVagaEstacionamento,
                request.getLinhaEstacionamento(),
                request.getColunaEstacionamento());

        VagaEstacionamento vagaEstacionamento = editarVagaEstacionamentoUseCase.execute(command);

        return ResponseEntity.status(201).body(EditarVagaEstacionamentoResponse.of(vagaEstacionamento));
    }
}