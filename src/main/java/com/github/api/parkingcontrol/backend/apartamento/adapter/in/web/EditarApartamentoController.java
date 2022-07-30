package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.EditarApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.requests.EditarApartamentoRequest;
import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses.EditarApartamentoResponse;
import com.github.api.parkingcontrol.backend.apartamento.application.EditarApartamentoUseCase;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/apartamento")
@RequiredArgsConstructor
public class EditarApartamentoController {

    private final EditarApartamentoUseCase editarApartamentoUseCase;

    @GetMapping("/editar-apartamento")
    public ResponseEntity<EditarApartamentoResponse> execute(@RequestParam String idApartamento,
                                                             @RequestBody @Valid EditarApartamentoRequest request) {

        EditarApartamentoCommand command = new EditarApartamentoCommand(
                idApartamento,
                request.getBlocoDoApartamento(),
                request.getNumeroDoApartamento());

        Apartamento apartamentoEditado = editarApartamentoUseCase.execute(command);

        return ResponseEntity.status(200).body(EditarApartamentoResponse.of(apartamentoEditado));
    }
}