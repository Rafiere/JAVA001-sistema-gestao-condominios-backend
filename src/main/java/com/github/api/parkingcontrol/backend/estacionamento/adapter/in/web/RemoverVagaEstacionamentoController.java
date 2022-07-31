package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.RemoverVagaEstacionamentoCommand;
import com.github.api.parkingcontrol.backend.estacionamento.application.RemoverVagaEstacionamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vaga-estacionamento")
@RequiredArgsConstructor
public class RemoverVagaEstacionamentoController {

    private final RemoverVagaEstacionamentoUseCase removerVagaEstacionamentoUseCase;

    @DeleteMapping("/remover-vaga-estacionamento")
    public ResponseEntity<Void> execute(@RequestParam String idVagaEstacionamento) {

        RemoverVagaEstacionamentoCommand command = new RemoverVagaEstacionamentoCommand(idVagaEstacionamento);

        removerVagaEstacionamentoUseCase.execute(command);

        return ResponseEntity.status(204).body(null);
    }
}