package com.github.api.parkingcontrol.backend.morador.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.morador.domain.entities.MoradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoradorRepository extends JpaRepository<MoradorEntity, String> {

    @Query("SELECT m FROM MoradorEntity m " +
            "WHERE UPPER(m.nome) LIKE CONCAT('%', :nomeCompletoMorador, '%') " +
            "OR UPPER(m.sobrenome) LIKE CONCAT('%', :nomeCompletoMorador, '%')")
    List<MoradorEntity> buscarPeloNomeCompleto(String nomeCompletoMorador);

    @Query("SELECT m.apartamentos.size FROM MoradorEntity m")
    boolean moradorPossuiAlgumApartamento(String idMorador);

    @Query("SELECT m.veiculos.size FROM MoradorEntity m")
    boolean moradorPossuiAlgumVeiculo(String idMorador);

    @Query("SELECT m.vagasEstacionamento.size FROM MoradorEntity m")
    boolean moradorPossuiAlgumaVagaEstacionamento(String idMorador);
}
