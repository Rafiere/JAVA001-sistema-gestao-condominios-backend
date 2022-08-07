package com.github.api.parkingcontrol.backend.usuario.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.usuario.domain.entities.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoEntity, String> {

}
