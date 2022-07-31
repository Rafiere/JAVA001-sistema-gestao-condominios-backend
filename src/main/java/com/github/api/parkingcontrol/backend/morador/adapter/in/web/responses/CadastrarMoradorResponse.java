package com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class CadastrarMoradorResponse {

    String id;

    String nome;

    String sobrenome;

    String cpf;

    List<Apartamento> apartamento;

    List<Veiculo> veiculos;

    List<VagaEstacionamento> vagasEstacionamento;

    public static CadastrarMoradorResponse of(Morador morador){

        return new CadastrarMoradorResponse(
                morador.getId(),
                morador.getNome(),
                morador.getSobrenome(),
                morador.getCpf(),
                morador.getApartamentos(),
                morador.getVeiculos(),
                morador.getVagasEstacionamento());
    }

    public static List<CadastrarMoradorResponse> of(List<Morador> moradores){

        return moradores.stream()
                .map(morador -> new CadastrarMoradorResponse(
                        morador.getId(),
                        morador.getNome(),
                        morador.getSobrenome(),
                        morador.getCpf(),
                        morador.getApartamentos(),
                        morador.getVeiculos(),
                        morador.getVagasEstacionamento()
                )).collect(Collectors.toList());
    }
}
