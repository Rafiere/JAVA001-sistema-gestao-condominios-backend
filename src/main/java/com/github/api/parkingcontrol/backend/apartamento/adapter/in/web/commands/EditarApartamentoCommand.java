package com.github.api.parkingcontrol.backend.apartamento.adapter.in.web.commands;

import com.github.api.parkingcontrol.backend.apartamento.domain.BlocoDoApartamento;
import lombok.Value;

@Value
public class EditarApartamentoCommand {

    String idApartamento;

    BlocoDoApartamento blocoDoApartamento;

    String numeroDoApartamento;
}
