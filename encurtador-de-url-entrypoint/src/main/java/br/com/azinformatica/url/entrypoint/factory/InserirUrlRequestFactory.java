package br.com.azinformatica.url.entrypoint.factory;

import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InserirUrlRequestFactory implements RequestFactory<InserirURLRequest> {
    @Override
    public InserirURLRequest create(Map<String, Object> body) {
        return InserirURLRequest
                .builder()
                .urlNaoEncurtada((String) body.get("urlNaoEncurtada"))
                .build();
    }
}
