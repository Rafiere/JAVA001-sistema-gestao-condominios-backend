package com.github.api.parkingcontrol.backend.config.security;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarUsuarioPeloUsernamePort;
import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BuscarUsuarioPeloUsernamePort buscarUsuarioPeloUsernamePort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuarioBuscado = buscarUsuarioPeloUsernamePort.buscarUsuarioPeloUsername(username);

        if(!usuarioBuscado.isEnabled()){

            throw new BusinessRuleException("Esse usuário não está ativo. Por favor, entre em contato com a " +
                    "administração do sistema ou realize o login com outro usuário.");
        }

        return usuarioBuscado;
    }
}
