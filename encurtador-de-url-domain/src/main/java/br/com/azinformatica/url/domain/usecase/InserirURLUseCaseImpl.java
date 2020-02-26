package br.com.azinformatica.url.domain.usecase;

import br.com.azinformatica.url.domain.entity.URL;
import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirURLResponse;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirURLUseCase;

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

        url = urlDataProvider.salvar(url);
        url.setUrlEncurtada(encode(url.getId()));

        return InserirURLResponse
                .builder()
                .id(url.getId())
                .urlNaoEncurtada(url.getUrlNaoEncurtada())
                .urlEncurtada(url.getUrlEncurtada())
                .build();
    }

    public static String encode(Long num) {
        int novoNum = Math.toIntExact(num);
        String alfabeto = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int tamanho = alfabeto.length();

        StringBuilder str = new StringBuilder();
        while (novoNum > 0) {
            str.insert(0, alfabeto.charAt(novoNum % tamanho));
            novoNum = novoNum / tamanho;
        }
        return str.toString();
    }

}
