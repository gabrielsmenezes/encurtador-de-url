package br.com.azinformatica.url.entrypoint.factory;

import br.com.azinformatica.url.domain.port.entrypoint.dto.BuscarUrlRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BuscarUrlRequestFactory implements RequestFactory<BuscarUrlRequest> {
    @Override
    public BuscarUrlRequest create(Map body) {
        return BuscarUrlRequest
                .builder()
                .urlEncurtada((String) body.get("c"))
                .build();
    }
}
