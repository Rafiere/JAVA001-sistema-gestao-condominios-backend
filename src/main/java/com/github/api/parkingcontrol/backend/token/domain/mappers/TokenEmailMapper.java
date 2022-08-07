package com.github.api.parkingcontrol.backend.token.domain.mappers;

import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import com.github.api.parkingcontrol.backend.token.domain.entities.TokenEmailEntity;
import com.github.api.parkingcontrol.backend.usuario.domain.mappers.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenEmailMapper {

    private final UsuarioMapper usuarioMapper;

    public TokenEmail fromEntity(TokenEmailEntity tokenEmailEntity){

        return new TokenEmail(
                tokenEmailEntity.getId(),
                tokenEmailEntity.getToken(),
                tokenEmailEntity.getDataDeCriacao(),
                tokenEmailEntity.getDataDeExpiracao(),
                usuarioMapper.fromEntity(tokenEmailEntity.getUsuario()));
    }

    public TokenEmailEntity fromDomain(TokenEmail tokenEmail){

        return new TokenEmailEntity(
                tokenEmail.getToken(),
                tokenEmail.getDataDeExpiracao(),
                usuarioMapper.fromDomain(tokenEmail.getUsuario()));
    }

    public TokenEmailEntity fromDomainComUserIdPredefinido(TokenEmail tokenEmail){

        return new TokenEmailEntity(
                tokenEmail.getToken(),
                tokenEmail.getDataDeExpiracao(),
                usuarioMapper.fromDomainComIdPredefinido(tokenEmail.getUsuario()));
    }
}
