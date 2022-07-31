package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.BuscarMoradorResponse;
import com.github.api.parkingcontrol.backend.morador.application.port.out.BuscarMoradorPeloNomeCompletoPort;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class BuscarMoradoresPeloNomeCompletoController {

    private final BuscarMoradorPeloNomeCompletoPort buscarMoradorPeloNomeCompletoPort;

    @GetMapping("/buscar-moradores-pelo-nome-completo")
    public ResponseEntity<List<BuscarMoradorResponse>> execute(@RequestParam String nomeCompletoMorador) {

        List<Morador> moradores =
                buscarMoradorPeloNomeCompletoPort.buscarMoradorPeloNomeCompleto(nomeCompletoMorador);

        return ResponseEntity.status(200).body(BuscarMoradorResponse.of(moradores));
    }
}