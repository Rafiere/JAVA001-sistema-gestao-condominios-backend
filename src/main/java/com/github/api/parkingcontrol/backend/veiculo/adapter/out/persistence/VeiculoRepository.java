package com.github.api.parkingcontrol.backend.veiculo.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.veiculo.domain.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, String> {
}
