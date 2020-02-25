package br.com.azinformatica.url.domain.port.entrypoint.usecase.base;

import br.com.azinformatica.url.domain.port.entrypoint.dto.base.Request;

public interface UseCase<R extends Request> {
    void execute(R request);
}
