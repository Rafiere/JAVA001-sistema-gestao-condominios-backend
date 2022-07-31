package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.RemoverMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.application.RemoverMoradorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class RemoverMoradorController {

    private final RemoverMoradorUseCase removerMoradorUseCase;

    @DeleteMapping("/excluir-morador")
    public ResponseEntity<Void> execute(@RequestParam String idMorador) {

        RemoverMoradorCommand command = new RemoverMoradorCommand(idMorador);

        removerMoradorUseCase.execute(command);

        return ResponseEntity.status(204).body(null);
    }
}