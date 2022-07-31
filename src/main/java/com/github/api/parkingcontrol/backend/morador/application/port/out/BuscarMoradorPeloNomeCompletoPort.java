package com.github.api.parkingcontrol.backend.morador.application.port.out;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;

import java.util.List;

public interface BuscarMoradorPeloNomeCompletoPort {

    List<Morador> buscarMoradorPeloNomeCompleto(String nomeCompletoMorador);
}