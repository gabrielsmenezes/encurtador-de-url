package br.com.azinformatica.url.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class URL {
    private Long id;
    private String urlEncurtada;
    private String urlNaoEncurtada;
}
