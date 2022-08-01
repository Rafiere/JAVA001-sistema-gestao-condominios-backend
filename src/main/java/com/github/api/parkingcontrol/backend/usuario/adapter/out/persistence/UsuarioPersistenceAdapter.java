package com.github.api.parkingcontrol.backend.usuario.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarUsuarioPeloUsernamePort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.CadastrarUsuarioPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeEmailJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.VerificarSeUsernameJaFoiCadastradoPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.UsuarioEntity;
import com.github.api.parkingcontrol.backend.usuario.domain.mappers.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements
        CadastrarUsuarioPort,
        VerificarSeEmailJaFoiCadastradoPort,
        VerificarSeUsernameJaFoiCadastradoPort,
        BuscarUsuarioPeloUsernamePort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {

        UsuarioEntity usuarioEntity = usuarioMapper.fromDomain(usuario);

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);

        return usuarioMapper.fromEntity(usuarioSalvo);
    }

    @Override
    public boolean verificarSeEmailJaFoiCadastrado(String email) {

        return usuarioRepository.verificaSeEmailJaFoiCadastrado(email);
    }

    @Override
    public boolean verificarSeUsernameJaFoiCadastrado(String username) {

        return usuarioRepository.verificaSeUsernameJaFoiCadastrado(username);
    }

    @Override
    public Usuario buscarUsuarioPeloUsername(String username) {

        UsuarioEntity usuarioEntity =
                usuarioRepository.findUsuarioEntityByUsernameIgnoreCase(username)
                        .orElseThrow(() -> new BusinessRuleException("Nenhum usuário com o username inserido foi encontrado."));

        return usuarioMapper.fromEntity(usuarioEntity);
    }
}
