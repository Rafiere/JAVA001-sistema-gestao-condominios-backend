package com.github.api.parkingcontrol.backend.usuario.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarCargosPorIdsPort;
import com.github.api.parkingcontrol.backend.usuario.application.port.out.BuscarTodosOsCargosPort;
import com.github.api.parkingcontrol.backend.usuario.domain.Cargo;
import com.github.api.parkingcontrol.backend.usuario.domain.mappers.CargoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CargoPersistenceAdapter implements
        BuscarTodosOsCargosPort,
        BuscarCargosPorIdsPort {

    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;

    @Override
    public List<Cargo> buscarTodosOsCargos() {

        return cargoRepository.findAll()
                .stream()
                .map(cargoMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cargo> buscarCargosPorIds(List<String> idsCargos) {

        return cargoRepository.findAllById(idsCargos)
                .stream()
                .map(cargoMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
