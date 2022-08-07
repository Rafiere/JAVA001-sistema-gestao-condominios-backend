package com.github.api.parkingcontrol.backend.token.domain;

import com.github.api.parkingcontrol.backend.token.domain.enums.TipoEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfirmacaoCadastro {

    private String id;

    private EmailPadrao emailPadrao;

    private LocalDateTime dataDeEnvio;

    private TipoEmail tipoEmail;
}
