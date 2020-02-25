package br.com.azinformatica.url.domain.entity;

import lombok.Builder;

@Builder
public class URL {
    private String urlEncurtada;
    private String urlNaoEncurtada;
}
