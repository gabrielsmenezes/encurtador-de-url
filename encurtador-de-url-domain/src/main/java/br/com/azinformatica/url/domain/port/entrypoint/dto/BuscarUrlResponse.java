package br.com.azinformatica.url.domain.port.entrypoint.dto;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuscarUrlResponse implements Response {
    private Long id;
    private String urlNaoEncurtada;
    private String urlEncurtada;
}
