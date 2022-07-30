package com.github.api.parkingcontrol.backend.apartamento.application.port.out;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;

public interface CadastrarApartamentoPort {

    Apartamento cadastrarApartamento(Apartamento apartamento);
}