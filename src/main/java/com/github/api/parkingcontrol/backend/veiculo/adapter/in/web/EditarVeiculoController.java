package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.EditarVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.requests.EditarVeiculoRequest;
import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.responses.EditarVeiculoResponse;
import com.github.api.parkingcontrol.backend.veiculo.application.EditarVeiculoUseCase;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/veiculo")
@RequiredArgsConstructor
public class EditarVeiculoController {

    private final EditarVeiculoUseCase editarVeiculoUseCase;

    @PutMapping("/editar-veiculo")
    public ResponseEntity<EditarVeiculoResponse> execute(@RequestParam String idVeiculo,
                                                         @RequestBody @Valid EditarVeiculoRequest request) {

        EditarVeiculoCommand command = new EditarVeiculoCommand(
                idVeiculo,
                request.getPlacaDoVeiculo(),
                request.getMarcaDoVeiculo(),
                request.getModeloDoVeiculo(),
                request.getCorDoVeiculo());

        Veiculo veiculoEditado = editarVeiculoUseCase.execute(command);

        return ResponseEntity.status(201).body(EditarVeiculoResponse.of(veiculoEditado));
    }
}