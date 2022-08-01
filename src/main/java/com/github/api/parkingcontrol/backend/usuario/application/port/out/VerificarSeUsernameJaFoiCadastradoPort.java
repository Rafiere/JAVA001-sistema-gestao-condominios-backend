package com.github.api.parkingcontrol.backend.usuario.application.port.out;

public interface VerificarSeUsernameJaFoiCadastradoPort {

    boolean verificarSeUsernameJaFoiCadastrado(String username);
}