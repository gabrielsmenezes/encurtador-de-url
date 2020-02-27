package br.com.azinformatica.url.domain.usecase;

import br.com.azinformatica.url.domain.entity.URL;
import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLResponse;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirURLUseCase;

import java.util.Objects;
import java.util.Random;

public class InserirURLUseCaseImpl implements InserirURLUseCase {

    private URLDataProvider urlDataProvider;

    public InserirURLUseCaseImpl(URLDataProvider urlDataProvider) {
        this.urlDataProvider = urlDataProvider;
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
            codigoValido = geraUrl();
        } while (Objects.nonNull(urlDataProvider.buscarPorUrlEncurtada(codigoValido)));
        return codigoValido;
    }

    public static String geraUrl() {
        String alfabeto = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int tamanho = alfabeto.length();
        int contador= 0;
        StringBuilder str = new StringBuilder();
        while (contador < 6) {
            str.insert(0, alfabeto.charAt(new Random().nextInt(tamanho)));
            contador++;
        }
        return str.toString();
    }

}
