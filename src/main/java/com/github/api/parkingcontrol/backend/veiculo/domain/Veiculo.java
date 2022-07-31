package com.github.api.parkingcontrol.backend.veiculo.domain;

import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    private String id;

    private String placaDoVeiculo;

    private String marcaDoVeiculo;

    private String modeloDoVeiculo;

    private String corDoVeiculo;
}
