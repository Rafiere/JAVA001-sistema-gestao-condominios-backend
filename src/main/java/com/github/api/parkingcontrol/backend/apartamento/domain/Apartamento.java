package com.github.api.parkingcontrol.backend.apartamento.domain;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Apartamento {

    private String id;

    private BlocoDoApartamento blocoDoApartamento;

    private String numeroDoApartamento;

    public Apartamento(BlocoDoApartamento blocoDoApartamento, String numeroDoApartamento) {
        this.blocoDoApartamento = blocoDoApartamento;
        this.numeroDoApartamento = numeroDoApartamento;
    }

    public void atualizar(BlocoDoApartamento blocoDoApartamento, String numeroDoApartamento) {

        this.blocoDoApartamento = blocoDoApartamento;
        this.numeroDoApartamento = numeroDoApartamento;
    }
}
