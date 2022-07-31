package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.CadastrarMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests.CadastrarMoradorRequest;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.CadastrarMoradorResponse;
import com.github.api.parkingcontrol.backend.morador.application.CadastrarMoradorUseCase;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.morador.domain.mappers.MoradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class CadastrarMoradorController {

    private final CadastrarMoradorUseCase cadastrarMoradorUseCase;

    @PostMapping("/cadastrar-morador")
    public ResponseEntity<CadastrarMoradorResponse> execute(@RequestBody @Valid CadastrarMoradorRequest cadastrarMoradorRequest) {

        CadastrarMoradorCommand command = new CadastrarMoradorCommand(
                cadastrarMoradorRequest.getNome(),
                cadastrarMoradorRequest.getSobrenome(),
                cadastrarMoradorRequest.getCpf(),
                cadastrarMoradorRequest.getApartamentosIds(),
                cadastrarMoradorRequest.getVeiculosIds(),
                cadastrarMoradorRequest.getVagasEstacionamentoId()
        );

        Morador morador = cadastrarMoradorUseCase.execute(command);

        return ResponseEntity.status(201).body(CadastrarMoradorResponse.of(morador));
    }
}