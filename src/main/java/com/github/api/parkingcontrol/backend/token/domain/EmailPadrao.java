package com.github.api.parkingcontrol.backend.token.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Essa classe servirá como base para qualquer email que está sendo
 * enviado na aplicação.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailPadrao {

    private String de;

    private String para;

    private String assunto;

    private String conteudoEmail;

    private String anexo;

    private String deNomeExibicao;

    private String idiomaDoEmail;

    private String nomeDeExibicao;

    private String localizacaoDoTemplate;
}
