package com.github.api.parkingcontrol.backend.token.application.port.out;

import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;

public interface SalvarTokenEmailPort {

    TokenEmail salvarTokenEmail(TokenEmail tokenEmail);
}
