package com.github.api.parkingcontrol.backend.apartamento.application;

import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands.BuscarApartamentoPorIdCommand;
import com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.responses.BuscarApartamentoPorIdResponse;
import com.github.api.parkingcontrol.backend.apartamento.application.port.out.BuscarApartamentoPorIdPort;
import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarApartamentoPorIdUseCase {

    private final BuscarApartamentoPorIdPort buscarApartamentoPorIdPort;

    public BuscarApartamentoPorIdResponse execute(BuscarApartamentoPorIdCommand buscarApartamentoPorIdCommand) {

        Apartamento apartamento =
                buscarApartamentoPorIdPort.buscarApartamentoPorId(buscarApartamentoPorIdCommand.getId());

        return BuscarApartamentoPorIdResponse.of(apartamento);
    }
}
