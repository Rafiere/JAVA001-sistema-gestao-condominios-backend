package com.github.api.parkingcontrol.backend.apartamento.application;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.RemoverApartamentoCommand;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.RemoverApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.VerificarSeExisteMoradorNoApartamentoPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoverApartamentoUseCase {

    private final RemoverApartamentoPort removerApartamentoPort;
    private final VerificarSeExisteMoradorNoApartamentoPort verificarSeExisteMoradorNoApartamentoPort;

    public void execute(RemoverApartamentoCommand command) {

        if(existeMoradorNoApartamento(command.getIdApartamento())){
            throw new BusinessRuleException("Um apartamento que possui moradores ativos não pode ser removido!");
        }

        removerApartamentoPort.removerApartamento(command.getIdApartamento());
    }

    private boolean existeMoradorNoApartamento(String idApartamento) {

        return verificarSeExisteMoradorNoApartamentoPort.verificarSeExisteMoradorNoApartamento(idApartamento);
    }
}
