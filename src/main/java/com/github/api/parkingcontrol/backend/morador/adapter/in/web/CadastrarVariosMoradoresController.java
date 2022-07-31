package com.github.api.parkingcontrol.backend.morador.adapter.in.web;

import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.CadastrarMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.CadastrarVariosMoradoresCommand;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.requests.CadastrarVariosMoradoresRequest;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses.CadastrarMoradorResponse;
import com.github.api.parkingcontrol.backend.morador.application.CadastrarVariosMoradoresUseCase;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/morador")
@RequiredArgsConstructor
public class CadastrarVariosMoradoresController {

    private final CadastrarVariosMoradoresUseCase cadastrarVariosMoradoresUseCase;

    @PostMapping("/cadastrar-moradores")
    public ResponseEntity<List<CadastrarMoradorResponse>> execute(@RequestBody @Valid CadastrarVariosMoradoresRequest request) {

        List<CadastrarMoradorCommand> commandList = request.getMoradores()
                .stream()
                .map(cadastrarMoradorRequest -> new CadastrarMoradorCommand(
                        cadastrarMoradorRequest.getNome(),
                        cadastrarMoradorRequest.getSobrenome(),
                        cadastrarMoradorRequest.getCpf(),
                        cadastrarMoradorRequest.getApartamentosIds(),
                        cadastrarMoradorRequest.getVeiculosIds(),
                        cadastrarMoradorRequest.getVagasEstacionamentoId()))
                .collect(Collectors.toList());

        CadastrarVariosMoradoresCommand command = new CadastrarVariosMoradoresCommand(commandList);

        List<Morador> moradoresCriados = cadastrarVariosMoradoresUseCase.execute(command);

        return ResponseEntity.status(201).body(CadastrarMoradorResponse.of(moradoresCriados));
    }
}