package br.com.azinformatica.url.entrypoint.factory;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;

import java.util.Map;

public interface RequestFactory<R extends Request> {
    R create(Map<String, Object> body);
}
