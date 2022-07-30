package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.CadastrarApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.requests.CadastrarApartamentoRequest;
import com.github.api.parkingcontrol.backend.apartamento.application.CadastrarApartamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/apartamento")
@RequiredArgsConstructor
public class CadastrarApartamentoController {

    private final CadastrarApartamentoUseCase cadastrarApartamentoUseCase;

    @PostMapping("/cadastrar-apartamento")
    public ResponseEntity<Void> execute(@RequestBody @Valid CadastrarApartamentoRequest request) {

        CadastrarApartamentoCommand command = new CadastrarApartamentoCommand(
                request.getBlocoDoApartamento(),
                request.getNumeroDoApartamento());

        cadastrarApartamentoUseCase.execute(command);

        return ResponseEntity.status(201).body(null);
    }
}