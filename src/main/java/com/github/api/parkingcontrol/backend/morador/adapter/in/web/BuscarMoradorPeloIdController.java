package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.BuscarMoradorResponse;
import com.github.api.parkingcontrol.backend.morador.application.port.out.BuscarMoradorPorIdPort;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class BuscarMoradorPeloIdController {

    private final BuscarMoradorPorIdPort buscarMoradorPorIdPort;

    @GetMapping("/buscar-morador-pelo-id")
    public ResponseEntity<BuscarMoradorResponse> execute(@RequestParam String idMorador) {

        Morador morador = buscarMoradorPorIdPort.buscarMoradorPorId(idMorador);

        return ResponseEntity.status(200).body(BuscarMoradorResponse.of(morador));
    }
}