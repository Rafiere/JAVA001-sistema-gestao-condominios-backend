package com.github.api.parkingcontrol.backend.usuario.adapter.in.web;

import com.github.api.parkingcontrol.backend.usuario.adapter.in.web.command.CadastrarUsuarioCommand;
import com.github.api.parkingcontrol.backend.usuario.adapter.in.web.requests.CadastrarUsuarioRequest;
import com.github.api.parkingcontrol.backend.usuario.adapter.in.web.responses.CadastrarUsuarioResponse;
import com.github.api.parkingcontrol.backend.usuario.application.CadastrarUsuarioUseCase;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class CadastrarUsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<CadastrarUsuarioResponse> execute(@RequestBody @Valid CadastrarUsuarioRequest request) {

        CadastrarUsuarioCommand command = new CadastrarUsuarioCommand(
                request.getEmail(),
                request.getUsername(),
                request.getPassword(),
                true,
                request.getCargos());

        Usuario usuarioCadastrado = cadastrarUsuarioUseCase.execute(command);

        return ResponseEntity.status(201).body(CadastrarUsuarioResponse.of(usuarioCadastrado));
    }
}