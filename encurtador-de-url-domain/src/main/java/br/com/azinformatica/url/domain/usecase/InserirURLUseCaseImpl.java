package br.com.azinformatica.url.domain.usecase;

import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLRequest;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirURLUseCase;

public class InserirURLUseCaseImpl implements InserirURLUseCase {

    private URLDataProvider urlDataProvider;

    public InserirURLUseCaseImpl(URLDataProvider urlDataProvider) {
        this.urlDataProvider = urlDataProvider;
    }

    @Override
    public void execute(InserirURLRequest request) {

    }
}
