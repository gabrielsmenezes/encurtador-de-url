package br.com.azinformatica.url.domain.usecase;

import br.com.azinformatica.url.domain.entity.URL;
import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLResponse;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirURLUseCase;
import br.com.azinformatica.url.domain.port.utils.GeradorDeUrl;

import java.util.Objects;

public class InserirURLUseCaseImpl implements InserirURLUseCase {

    private URLDataProvider urlDataProvider;

    private GeradorDeUrl geradorDeUrl;

    public InserirURLUseCaseImpl(URLDataProvider urlDataProvider, GeradorDeUrl geradorDeUrl) {
        this.urlDataProvider = urlDataProvider;
        this.geradorDeUrl = geradorDeUrl;
    }

    @Override
    public InserirURLResponse execute(InserirURLRequest request) {
        URL url = URL
                .builder()
                .urlNaoEncurtada(request.getUrlNaoEncurtada())
                .build();

        url.setUrlEncurtada(geraUrlValida());

        url = urlDataProvider.salvar(url);

        return InserirURLResponse
                .builder()
                .id(url.getId())
                .urlNaoEncurtada(url.getUrlNaoEncurtada())
                .urlEncurtada(url.getUrlEncurtada())
                .build();
    }

    private String geraUrlValida() {
        String codigoValido;
        do {
            codigoValido = geradorDeUrl.geraUrl();
        } while (Objects.nonNull(urlDataProvider.buscarPorUrlEncurtada(codigoValido)));
        return codigoValido;
    }

}
