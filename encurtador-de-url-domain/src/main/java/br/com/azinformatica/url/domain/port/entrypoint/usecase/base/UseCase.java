package br.com.azinformatica.url.domain.port.entrypoint.usecase.base;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;
import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Response;

public interface UseCase<R extends Request> {
    Response execute(R request);
}
