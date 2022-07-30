package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.BuscarApartamentoPorIdCommand;
import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses.BuscarApartamentoPorIdResponse;
import com.github.api.parkingcontrol.backend.apartamento.application.BuscarApartamentoPorIdUseCase;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentoPorIdPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/apartamento")
@RequiredArgsConstructor
public class BuscarApartamentoPorIdController {

    private final BuscarApartamentoPorIdUseCase buscarApartamentoPorIdUseCase;

    @GetMapping("/buscar-apartamento-por-id")
    public ResponseEntity<BuscarApartamentoPorIdResponse> execute(@RequestParam String id) {

        BuscarApartamentoPorIdCommand command = new BuscarApartamentoPorIdCommand(id);

        BuscarApartamentoPorIdResponse response = buscarApartamentoPorIdUseCase.execute(command);

        return ResponseEntity.status(200).body(response);
    }
}