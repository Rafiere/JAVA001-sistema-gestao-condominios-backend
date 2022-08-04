package com.github.api.parkingcontrol.backend.usuario.application;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.token.application.EnviarEmailConfirmacaoCadastroUseCase;
import com.github.api.parkingcontrol.backend.token.application.GerarTokenEmailHelper;
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
    private final SalvarTokenEmailPort salvarTokenEmailPort;
    private final GerarTokenEmailHelper gerarTokenEmailHelper;
    private final BuscarCargosPorIdsPort buscarCargosPorIdsPort;


    private final EnviarEmailConfirmacaoCadastroUseCase enviarEmailConfirmacaoCadastroUseCase;

    public Usuario execute(CadastrarUsuarioCommand command) {

        if(emailJaFoiCadastrado(command.getEmail())){

            throw new BusinessRuleException("Esse email já está em uso. Por favor, envie um outro email.");
        }

        if(usernameJaFoiCadastrado(command.getUsername())){

            throw new BusinessRuleException("Esse username já está em uso. Por favor, utilize um outro username.");
        }

        List<Cargo> cargosBuscados =
                buscarCargosPorIdsPort.buscarCargosPorIds(command.getIdsCargosDoUsuario());

        Usuario usuario = new Usuario(
                command.getEmail(),
                command.getPassword(),
                command.getUsername(),
                command.isAtivo(),
                cargosBuscados);

        Usuario usuarioCriado = cadastrarUsuarioPort.cadastrarUsuario(usuario);

        enviarEmailDeConfirmacaoDeCadastro(usuarioCriado);

        return usuarioCriado;
    }

    private boolean usernameJaFoiCadastrado(String username) {

        return verificarSeUsernameJaFoiCadastradoPort.verificarSeUsernameJaFoiCadastrado(username);
    }

    private boolean emailJaFoiCadastrado(String email) {

        return verificarSeEmailJaFoiCadastradoPort.verificarSeEmailJaFoiCadastrado(email);
    }

    private void enviarEmailDeConfirmacaoDeCadastro(Usuario usuario){

        TokenEmail tokenEmail = gerarTokenEmailHelper.gerarToken();

        tokenEmail.definirUsuario(usuario);

        TokenEmail tokenEmailSalvo = salvarTokenEmailPort.salvarTokenEmail(tokenEmail);

        enviarEmailConfirmacaoCadastroUseCase.execute(tokenEmailSalvo);
    }
}
