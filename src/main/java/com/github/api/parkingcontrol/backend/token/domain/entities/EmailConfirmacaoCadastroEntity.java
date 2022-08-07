package com.github.api.parkingcontrol.backend.token.domain.entities;

import com.github.api.parkingcontrol.backend.token.domain.EmailPadrao;
import com.github.api.parkingcontrol.backend.token.domain.enums.TipoEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmailConfirmacaoCadastroEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    @Embedded
    private EmailPadrao emailPadrao;

    private LocalDateTime dataDeEnvio;

    private TipoEmail tipoEmail;
}
