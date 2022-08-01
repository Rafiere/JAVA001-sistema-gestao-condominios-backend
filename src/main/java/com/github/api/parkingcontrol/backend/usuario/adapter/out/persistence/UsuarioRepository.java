package com.github.api.parkingcontrol.backend.usuario.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.usuario.domain.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    @Query("SELECT (COUNT(u) > 0) " +
            "FROM UsuarioEntity u " +
            "WHERE UPPER(:email) = UPPER(u.email) ")
    boolean verificaSeEmailJaFoiCadastrado(String email);

    @Query("SELECT (COUNT(u) > 0) " +
            "FROM UsuarioEntity u " +
            "WHERE UPPER(:username) = UPPER(u.username)")
    boolean verificaSeUsernameJaFoiCadastrado(String username);

    Optional<UsuarioEntity> findUsuarioEntityByUsernameIgnoreCase(String username);
}
