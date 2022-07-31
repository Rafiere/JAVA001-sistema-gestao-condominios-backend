package com.github.api.parkingcontrol.backend.apartamento.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.apartamento.domain.entities.ApartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<ApartamentoEntity, String> {

    @Query("SELECT COUNT(m) " +
            "FROM MoradorEntity m " +
            "LEFT JOIN m.apartamentos ap " +
            "WHERE ap.id =: idApartamento ")
    boolean verificarSeExisteMoradorNoApartamento(String idApartamento);
}
