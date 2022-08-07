package com.github.api.parkingcontrol.backend.token.application;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.token.adapter.in.web.command.AtivarUsuarioPeloTokenCommand;
import com.github.api.parkingcontrol.backend.token.application.port.out.BuscarTokenEmailPeloTokenPort;
import com.github.api.parkingcontrol.backend.token.application.port.out.SalvarTokenEmailPort;
import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.AtualizarUsuarioPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.CadastrarUsuarioPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AtivarUsuarioPeloTokenUseCase {

    private final BuscarTokenEmailPeloTokenPort buscarTokenEmailPeloTokenPort;
    private final AtualizarUsuarioPort atualizarUsuarioPort;

    public Usuario execute(AtivarUsuarioPeloTokenCommand command) {

        TokenEmail tokenBuscado =
                buscarTokenEmailPeloTokenPort.buscarTokenEmailPeloToken(command.getTokenDeConfirmacao());

        if(tokenBuscado.getUsuario().isAtivo()){

            throw new BusinessRuleException("Esse usuário já está ativado.");
        }

        if(tokenBuscado.getDataDeExpiracao().isBefore(LocalDateTime.now())){

            throw new BusinessRuleException("Esse token está expirado.");
        }

        tokenBuscado.getUsuario().ativarContaDoUsuario();

        return atualizarUsuarioPort.atualizarUsuario(tokenBuscado.getUsuario());
    }
}
