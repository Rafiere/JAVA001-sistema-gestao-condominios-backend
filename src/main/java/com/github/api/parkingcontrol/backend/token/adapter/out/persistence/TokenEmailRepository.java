package com.github.api.parkingcontrol.backend.token.adapter.out.persistence;

import com.github.api.parkingcontrol.backend.token.domain.entities.TokenEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TokenEmailRepository extends JpaRepository<TokenEmailEntity, String> {


    @Query("SELECT token FROM TokenEmailEntity token " +
            "WHERE token.token = :token")
    Optional<TokenEmailEntity> buscarTokenEmailPeloToken(String token);

    void deleteTokenEmailEntityByToken(String token);
}
