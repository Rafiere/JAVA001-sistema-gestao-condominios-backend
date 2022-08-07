package com.github.api.parkingcontrol.backend.token.application.events;

import com.github.api.parkingcontrol.backend.token.application.components.CriarEEnviarEmailConfirmacaoCadastroComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistroDeUsuarioListener implements ApplicationListener<EnviarEmailDeConfirmacaoCadastroEvent> {

    private final CriarEEnviarEmailConfirmacaoCadastroComponent criarEEnviarEmailConfirmacaoCadastroComponent;

    @Override
    public void onApplicationEvent(EnviarEmailDeConfirmacaoCadastroEvent event) {

        this.enviarEmail(event);
    }

    private void enviarEmail(EnviarEmailDeConfirmacaoCadastroEvent event){

        criarEEnviarEmailConfirmacaoCadastroComponent.execute(event.getTokenEmail());
    }
}
