package com.github.api.parkingcontrol.backend.apartamento.application.port.out;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;

import java.util.List;

public interface BuscarApartamentosPorIdsPort {

    List<Apartamento> buscarApartamentosPorId(List<String> idsApartamentos);
}