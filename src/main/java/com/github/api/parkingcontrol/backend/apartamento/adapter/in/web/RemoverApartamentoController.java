package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.RemoverApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.application.RemoverApartamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/apartamento")
@RequiredArgsConstructor
public class RemoverApartamentoController {

    private final RemoverApartamentoUseCase removerApartamentoUseCase;

    @DeleteMapping("/remover-apartamento")
    public ResponseEntity<Void> execute(@RequestParam String idApartamento) {

        RemoverApartamentoCommand command = new RemoverApartamentoCommand(idApartamento);

        removerApartamentoUseCase.execute(command);

        return ResponseEntity.status(204).body(null);
    }
}