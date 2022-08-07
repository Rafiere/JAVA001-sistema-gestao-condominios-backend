package com.github.api.parkingcontrol.backend.token.domain.entities;

import com.github.api.parkingcontrol.backend.usuario.domain.entities.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TokenEmailEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    private String token;

    private final LocalDateTime dataDeCriacao = LocalDateTime.now();

    private LocalDateTime dataDeExpiracao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private UsuarioEntity usuario;
}
