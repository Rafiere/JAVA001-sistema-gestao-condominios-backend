package com.github.api.parkingcontrol.backend.usuario.application;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.usuario.adapter.in.web.command.CadastrarUsuarioCommand;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.CadastrarUsuarioPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeEmailJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeUsernameJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {

    private final CadastrarUsuarioPort cadastrarUsuarioPort;
    private final VerificarSeEmailJaFoiCadastradoPort verificarSeEmailJaFoiCadastradoPort;
    private final VerificarSeUsernameJaFoiCadastradoPort verificarSeUsernameJaFoiCadastradoPort;

    public Usuario execute(CadastrarUsuarioCommand command) {

        if(emailJaFoiCadastrado(command.getEmail())){

            throw new BusinessRuleException("Esse email já está em uso. Por favor, envie um outro email.");
        }

        if(usernameJaFoiCadastrado(command.getUsername())){

            throw new BusinessRuleException("Esse username já está em uso. Por favor, utilize um outro username.");
        }

        Usuario usuario = new Usuario(
                command.getEmail(),
                command.getPassword(),
                command.getUsername(),
                command.isAtivo(),
                command.getCargos());

        return cadastrarUsuarioPort.cadastrarUsuario(usuario);
    }

    private boolean usernameJaFoiCadastrado(String username) {

        return verificarSeUsernameJaFoiCadastradoPort.verificarSeUsernameJaFoiCadastrado(username);
    }

    private boolean emailJaFoiCadastrado(String email) {

        return verificarSeEmailJaFoiCadastradoPort.verificarSeEmailJaFoiCadastrado(email);
    }
}
