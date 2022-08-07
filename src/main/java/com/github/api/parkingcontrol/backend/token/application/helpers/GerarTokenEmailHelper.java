package com.github.api.parkingcontrol.backend.token.application.helpers;

import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GerarTokenEmailHelper {

    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom();

    @Value("${environment.token_validation_in_seconds}")
    private Integer validadeDoTokenEmSegundos;

    public TokenEmail gerarToken() {

        return criarTokenEmail();
    }

    private TokenEmail criarTokenEmail() {

        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()));

        return new TokenEmail(
                tokenValue,
                LocalDateTime.now().plusSeconds(validadeDoTokenEmSegundos));
    }
}
