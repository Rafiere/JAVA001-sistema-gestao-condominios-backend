package com.github.api.parkingcontrol.backend.morador.application.port.out;

public interface VerificarSeMoradorPossuiAlgumaVagaEstacionamentoPort {

    boolean verificarSeMoradorPossuiAlgumaVagaEstacionamento(String idMorador);
}