package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.RemoverVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.application.RemoverVeiculoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/veiculo")
@RequiredArgsConstructor
public class RemoverVeiculoController {

    private final RemoverVeiculoUseCase removerVeiculoUseCase;

    @DeleteMapping("/remover-veiculo")
    public ResponseEntity<Void> execute(@RequestParam String idVeiculo) {

        RemoverVeiculoCommand command = new RemoverVeiculoCommand(idVeiculo);

        removerVeiculoUseCase.execute(command);

        return ResponseEntity.status(204).body(null);
    }
}