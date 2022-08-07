package com.github.api.parkingcontrol.backend.token.application.events;

import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EnviarEmailDeConfirmacaoCadastroEvent extends ApplicationEvent {

    private final TokenEmail tokenEmail;

    public EnviarEmailDeConfirmacaoCadastroEvent(TokenEmail tokenEmail){

        super(tokenEmail);
        this.tokenEmail = tokenEmail;
    }
}
