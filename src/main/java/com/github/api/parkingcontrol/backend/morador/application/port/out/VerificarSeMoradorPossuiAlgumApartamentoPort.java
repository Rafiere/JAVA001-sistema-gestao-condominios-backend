package com.github.api.parkingcontrol.backend.morador.application.port.out;

public interface VerificarSeMoradorPossuiAlgumApartamentoPort {

    boolean verificarSeMoradorPossuiAlgumApartamento(String idMorador);
}