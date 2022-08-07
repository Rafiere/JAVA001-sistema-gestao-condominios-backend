package com.github.api.parkingcontrol.backend.token.domain;

import com.github.api.parkingcontrol.backend.usuario.domain.Usuario;
import com.github.api.parkingcontrol.backend.usuario.domain.entities.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenEmail {

    private String id;

    private String token;

    private LocalDateTime dataDeCriacao;

    private LocalDateTime dataDeExpiracao;

    private Usuario usuario;

    public TokenEmail(String token,
                      LocalDateTime dataDeCriacao,
                      LocalDateTime dataDeExpiracao,
                      Usuario usuario){

        this.token = token;
        this.dataDeCriacao = dataDeCriacao;
        this.dataDeExpiracao = dataDeExpiracao;
        this.usuario = usuario;
    }

    public TokenEmail(String token, LocalDateTime dataDeExpiracao) {
        this.token = token;
        this.dataDeExpiracao = dataDeExpiracao;
    }

    public void definirUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public String obterEmailUsuario(){

        return this.usuario.getEmail();
    }
}
