package com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.command.BuscarVagaPorIdCommand;
import com.github.api.parkingcontrol.backend.estacionamento.adapter.in.web.responses.BuscarVagaEstacionamentoPorIdResponse;
import com.github.api.parkingcontrol.backend.estacionamento.application.port.out.BuscarVagaEstacionamentoPorIdPort;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vaga-estacionamento")
@RequiredArgsConstructor
public class BuscarVagaEstacionamentoPorIdController {

    private final BuscarVagaEstacionamentoPorIdPort buscarVagaEstacionamentoPorIdPort;

    @GetMapping("/buscar-vaga-estacionamento-por-id/")
    public ResponseEntity<BuscarVagaEstacionamentoPorIdResponse> execute(@RequestParam String idVagaEstacionamento){

        BuscarVagaPorIdCommand command = new BuscarVagaPorIdCommand(idVagaEstacionamento);

        VagaEstacionamento vagaEstacionamento =
                buscarVagaEstacionamentoPorIdPort.buscarVagaEstacionamentoPorId(command.getId());

        return ResponseEntity.status(200).body(BuscarVagaEstacionamentoPorIdResponse.of(vagaEstacionamento));
    }
}
