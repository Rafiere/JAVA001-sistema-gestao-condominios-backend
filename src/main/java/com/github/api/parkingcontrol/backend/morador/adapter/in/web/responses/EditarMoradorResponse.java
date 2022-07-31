package com.github.api.parkingcontrol.backend.morador.adapter.in.web.responses;

import com.github.api.parkingcontrol.backend.apartamento.domain.Apartamento;
import com.github.api.parkingcontrol.backend.estacionamento.domain.VagaEstacionamento;
import com.github.api.parkingcontrol.backend.morador.domain.Morador;
import com.github.api.parkingcontrol.backend.veiculo.domain.Veiculo;
import lombok.Value;

import java.util.List;

@Value
public class EditarMoradorResponse {

    String idMorador;

    String nome;

    String sobrenome;

    String cpf;

    List<Apartamento> apartamentos;

    List<Veiculo> veiculos;

    List<VagaEstacionamento> vagasEstacionamento;

    public static EditarMoradorResponse of(Morador moradorEditado) {

        return new EditarMoradorResponse(
                moradorEditado.getId(),
                moradorEditado.getNome(),
                moradorEditado.getSobrenome(),
                moradorEditado.getCpf(),
                moradorEditado.getApartamentos(),
                moradorEditado.getVeiculos(),
                moradorEditado.getVagasEstacionamento());
    }
}
