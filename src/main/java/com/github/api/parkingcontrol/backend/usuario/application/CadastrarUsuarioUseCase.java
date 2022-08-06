package com.github.api.parkingcontrol.backend.usuario.application;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.token.application.components.CriarEEnviarEmailConfirmacaoCadastroComponent;
import com.github.api.parkingcontrol.backend.token.application.helpers.GerarTokenEmailHelper;
import com.github.api.parkingcontrol.backend.token.application.port.out.SalvarTokenEmailPort;
import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import com.github.api.parkingcontrol.backend.usuario.adapter.in.web.command.CadastrarUsuarioCommand;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarCargosPorIdsPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.CadastrarUsuarioPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeEmailJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeUsernameJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CadastrarUsuarioUseCase {

    private final CadastrarUsuarioPort cadastrarUsuarioPort;
    private final VerificarSeEmailJaFoiCadastradoPort verificarSeEmailJaFoiCadastradoPort;
    private final VerificarSeUsernameJaFoiCadastradoPort verificarSeUsernameJaFoiCadastradoPort;
    private final GerarTokenEmailHelper gerarTokenEmailHelper;
    private final SalvarTokenEmailPort salvarTokenEmailPort;
    private final BuscarCargosPorIdsPort buscarCargosPorIdsPort;

    private final PasswordEncoder passwordEncoder;


    private final CriarEEnviarEmailConfirmacaoCadastroComponent criarEEnviarEmailConfirmacaoCadastroComponent;

    public Usuario execute(CadastrarUsuarioCommand command) {

        if(emailJaFoiCadastrado(command.getEmail())){

            throw new BusinessRuleException("Esse email já está em uso. Por favor, utilize um outro email.");
        }

        if(usernameJaFoiCadastrado(command.getUsername())){

            throw new BusinessRuleException("Esse username já está em uso. Por favor, utilize um outro username.");
        }

        List<Cargo> cargosBuscados =
                buscarCargosPorIdsPort.buscarCargosPorIds(command.getIdsCargosDoUsuario());

        String senhaComEncriptacao = passwordEncoder.encode(command.getPassword());

        Usuario usuario = new Usuario(
                command.getEmail(),
                command.getUsername(),
                senhaComEncriptacao,
                command.isAtivo(),
                cargosBuscados);

        Usuario usuarioCadastrado = cadastrarUsuarioPort.cadastrarUsuario(usuario);

        TokenEmail token = gerarESalvarToken(usuarioCadastrado);

        enviarEmailDeConfirmacaoDeCadastro(token);

        return usuarioCadastrado;
    }

    private TokenEmail gerarESalvarToken(Usuario usuario) {

        TokenEmail tokenEmail = gerarTokenEmailHelper.gerarToken();

        tokenEmail.definirUsuario(usuario); //Até aqui, o usuário é definido corretamente.

        return salvarTokenEmailPort.salvarTokenEmail(tokenEmail);
    }

    private boolean usernameJaFoiCadastrado(String username) {

        return verificarSeUsernameJaFoiCadastradoPort.verificarSeUsernameJaFoiCadastrado(username);
    }

    private boolean emailJaFoiCadastrado(String email) {

        return verificarSeEmailJaFoiCadastradoPort.verificarSeEmailJaFoiCadastrado(email);
    }

    private void enviarEmailDeConfirmacaoDeCadastro(TokenEmail tokenEmail){

        criarEEnviarEmailConfirmacaoCadastroComponent.execute(tokenEmail);
    }
}
