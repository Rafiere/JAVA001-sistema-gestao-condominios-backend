package com.github.api.parkingcontrol.backend.veiculo.adapter.in.web;

import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.commands.CadastrarVeiculoCommand;
import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.requests.CadastrarVeiculoRequest;
import com.github.api.parkingcontrol.backend.veiculo.adapter.in.web.responses.CadastrarVeiculoResponse;
import com.github.api.parkingcontrol.backend.veiculo.application.CadastrarVeiculoUseCase;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/veiculo")
@RequiredArgsConstructor
public class CadastrarVeiculoController {

    private final CadastrarVeiculoUseCase cadastrarVeiculoUseCase;

    @PostMapping("/cadastrar-veiculo")
    public ResponseEntity<CadastrarVeiculoResponse> execute(@RequestBody @Valid CadastrarVeiculoRequest request) {

        CadastrarVeiculoCommand command = new CadastrarVeiculoCommand(
                request.getPlacaDoVeiculo(),
                request.getMarcaDoVeiculo(),
                request.getModeloDoVeiculo(),
                request.getCorDoVeiculo());

        Veiculo veiculoCadastrado = cadastrarVeiculoUseCase.execute(command);

        return ResponseEntity.status(201).body(CadastrarVeiculoResponse.of(veiculoCadastrado));
    }
}