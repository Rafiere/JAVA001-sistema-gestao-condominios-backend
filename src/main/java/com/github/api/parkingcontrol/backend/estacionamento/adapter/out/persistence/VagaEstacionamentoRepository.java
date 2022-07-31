package com.github.api.parkingcontrol.backend.estacionamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.estacionamento.domain.entities.VagaEstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaEstacionamentoRepository extends JpaRepository<VagaEstacionamentoEntity, String> {

}
