package com.github.api.parkingcontrol.backend.usuario.adapter.in.web;

import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarTodosOsCargosPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cargos")
@RequiredArgsConstructor
public class BuscarTodosOsCargosController {

    private final BuscarTodosOsCargosPort buscarTodosOsCargosPort;

    @GetMapping("/buscar-todos-os-cargos")
    public ResponseEntity<List<Cargo>> execute() {

        List<Cargo> cargosBuscados = buscarTodosOsCargosPort.buscarTodosOsCargos();

        return ResponseEntity.status(200).body(cargosBuscados);
    }
}