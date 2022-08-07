package com.github.api.parkingcontrol.backend.token.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.token.application.port.out.BuscarTokenEmailPeloTokenPort;
import com.github.api.parkingcontrol.backend.token.application.port.out.RemoverTokenEmailPeloTokenPort;
import com.github.api.parkingcontrol.backend.token.application.port.out.SalvarTokenEmailPort;
import com.github.api.parkingcontrol.backend.token.domain.TokenEmail;
import com.github.api.parkingcontrol.backend.token.domain.entities.TokenEmailEntity;
import com.github.api.parkingcontrol.backend.token.domain.mappers.TokenEmailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenEmailPersistenceAdapter implements
        BuscarTokenEmailPeloTokenPort,
        RemoverTokenEmailPeloTokenPort,
        SalvarTokenEmailPort {


    //Estou tomando NPE ao enviar a requisição de cadastrar novo usuário. preciso debuggar.
    private final TokenEmailRepository tokenEmailRepository;
    private final TokenEmailMapper tokenEmailMapper;

    @Override
    public TokenEmail buscarTokenEmailPeloToken(String token) {

        return tokenEmailRepository.buscarTokenEmailPeloToken(token)
                .map(tokenEmailMapper::fromEntity)
                .orElseThrow(() -> new BusinessRuleException("Esse token não existe."));
    }

    @Override
    public void removerTokenEmailPeloToken(String token) {

        tokenEmailRepository.deleteTokenEmailEntityByToken(token);
    }

    @Override
    public TokenEmail salvarTokenEmail(TokenEmail tokenEmail) {

        TokenEmailEntity tokenEmailEntity = tokenEmailMapper.fromDomainComUserIdPredefinido(tokenEmail);

        TokenEmailEntity tokenEmailSalvo = tokenEmailRepository.save(tokenEmailEntity);

        return tokenEmailMapper.fromEntity(tokenEmailSalvo);
    }
}
