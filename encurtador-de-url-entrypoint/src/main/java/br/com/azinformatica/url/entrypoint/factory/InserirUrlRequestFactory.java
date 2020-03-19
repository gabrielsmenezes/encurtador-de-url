package br.com.azinformatica.url.entrypoint.factory;

import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirUrlRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InserirUrlRequestFactory implements RequestFactory<InserirUrlRequest> {
    @Override
    public InserirUrlRequest create(Map<String, Object> body) {
        return InserirUrlRequest
                .builder()
                .urlNaoEncurtada((String) body.get("urlNaoEncurtada"))
                .build();
    }
}
