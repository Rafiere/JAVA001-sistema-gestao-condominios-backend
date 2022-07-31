package com.github.api.parkingcontrol.backend.morador.application.port.out;

public interface VerificarSeMoradorPossuiAlgumVeiculoPort {

    boolean verificarSeMoradorPossuiAlgumVeiculo(String idMorador);
}