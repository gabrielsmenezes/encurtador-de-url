package br.com.azinformatica.url.domain.port.entrypoint.dto;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BuscarUrlRequest implements Request {
    private String urlEncurtada;
}
