package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.responses.BuscarVeiculoPeloIdResponse;
import com.github.api.parkingcontrol.backend.veiculo.application.port.out.BuscarVeiculoPeloIdPort;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/veiculo")
@RequiredArgsConstructor
public class BuscarVeiculoPeloIdController {

    private final BuscarVeiculoPeloIdPort buscarVeiculoPeloIdPort;

    @GetMapping("/buscar-veiculo-pelo-id")
    public ResponseEntity<BuscarVeiculoPeloIdResponse> execute(@RequestParam String idVeiculo) {

        Veiculo veiculo = buscarVeiculoPeloIdPort.buscarVeiculoPeloId(idVeiculo);

        return ResponseEntity.status(200).body(BuscarVeiculoPeloIdResponse.of(veiculo));
    }
}