package com.github.api.parkingcontrol.backend.morador.application;

import com.github.api.parkingcontrol.backend.config.exceptions.BusinessRuleException;
import com.github.api.parkingcontrol.backend.morador.adapter.in.web.command.RemoverMoradorCommand;
import com.github.api.parkingcontrol.backend.morador.application.port.out.RemoverMoradorPort;
import com.github.api.parkingcontrol.backend.morador.application.port.out.VerificarSeMoradorPossuiAlgumApartamentoPort;
import com.github.api.parkingcontrol.backend.morador.application.port.out.VerificarSeMoradorPossuiAlgumVeiculoPort;
import com.github.api.parkingcontrol.backend.morador.application.port.out.VerificarSeMoradorPossuiAlgumaVagaEstacionamentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RemoverMoradorUseCase {

    private final RemoverMoradorPort removerMoradorPort;
    private final VerificarSeMoradorPossuiAlgumApartamentoPort verificarSeMoradorPossuiAlgumApartamentoPort;
    private final VerificarSeMoradorPossuiAlgumVeiculoPort verificarSeMoradorPossuiAlgumVeiculoPort;
    private final VerificarSeMoradorPossuiAlgumaVagaEstacionamentoPort verificarSeMoradorPossuiAlgumaVagaDeEstacionamentoPort;


    public void execute(RemoverMoradorCommand command) {

        if(moradorPossuiAlgumApartamento(command.getIdMorador()) ||
           moradorPossuiAlgumVeiculo(command.getIdMorador()) ||
           moradorPossuiAlgumaVagaEstacionamento(command.getIdMorador())){

            throw new BusinessRuleException(
                    "O morador com o id " + command.getIdMorador() + "não pode ser removido. Ele " +
                    "possui algum apartamento, veículo ou vaga de " +
                    "estacionamento em seu nome. Tente novamente após desvincular todas as posses desse morador.");
        }

        removerMoradorPort.removerMorador(command.getIdMorador());
    }

    private boolean moradorPossuiAlgumApartamento(String idMorador) {

        return verificarSeMoradorPossuiAlgumApartamentoPort.verificarSeMoradorPossuiAlgumApartamento(idMorador);
    }

    private boolean moradorPossuiAlgumVeiculo(String idMorador){

        return verificarSeMoradorPossuiAlgumVeiculoPort.verificarSeMoradorPossuiAlgumVeiculo(idMorador);
    }

    private boolean moradorPossuiAlgumaVagaEstacionamento(String idMorador){

        return verificarSeMoradorPossuiAlgumaVagaDeEstacionamentoPort.verificarSeMoradorPossuiAlgumaVagaEstacionamento(idMorador);
    }
}
