package br.com.azinformatica.url.domain.port.entrypoint.dto;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;
import lombok.Builder;

@Builder
public class InserirURLRequest implements Request {
    private String urlNaoEncurtada;
}
