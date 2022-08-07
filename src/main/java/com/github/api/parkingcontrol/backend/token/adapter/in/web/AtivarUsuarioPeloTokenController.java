package com.github.api.parkingcontrol.backend.token.adapter.in.web;

import com.github.api.parkingcontrol.backend.token.adapter.in.web.command.AtivarUsuarioPeloTokenCommand;
import com.github.api.parkingcontrol.backend.token.adapter.in.web.response.AtivarUsuarioPeloTokenResponse;
import com.github.api.parkingcontrol.backend.token.application.AtivarUsuarioPeloTokenUseCase;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class AtivarUsuarioPeloTokenController {

    private final AtivarUsuarioPeloTokenUseCase ativarUsuarioPeloTokenUseCase;

    @PostMapping("/confirmarEmail/{tokenDeConfirmacao}")
    public ResponseEntity<AtivarUsuarioPeloTokenResponse> execute(@PathVariable String tokenDeConfirmacao) {

        AtivarUsuarioPeloTokenCommand command =
                new AtivarUsuarioPeloTokenCommand(tokenDeConfirmacao);

        Usuario usuario = ativarUsuarioPeloTokenUseCase.execute(command);

        return ResponseEntity.status(201).body(AtivarUsuarioPeloTokenResponse.of(usuario));
    }
}