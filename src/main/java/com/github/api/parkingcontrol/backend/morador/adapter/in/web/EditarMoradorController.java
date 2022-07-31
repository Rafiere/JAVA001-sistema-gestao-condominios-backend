package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.EditarMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests.EditarMoradorRequest;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.EditarMoradorResponse;
import com.github.api.parkingcontrol.backend.morador.application.EditarMoradorUseCase;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class EditarMoradorController {

    private final EditarMoradorUseCase editarMoradorUseCase;

    @PutMapping("/editar-morador")
    public ResponseEntity<EditarMoradorResponse> execute(@RequestParam String idMorador,
                                                         @RequestBody EditarMoradorRequest request) {

        EditarMoradorCommand command = new EditarMoradorCommand(
                idMorador,
                request.getNome(),
                request.getSobrenome(),
                request.getCpf(),
                request.getApartamentosIds(),
                request.getVeiculosIds(),
                request.getVagasEstacionamentoId());

        Morador moradorEditado = editarMoradorUseCase.execute(command);

        return ResponseEntity.status(201).body(EditarMoradorResponse.of(moradorEditado));
    }
}