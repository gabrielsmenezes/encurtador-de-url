package br.com.azinformatica.url.domain.port.dataprovider;

import br.com.azinformatica.url.domain.entity.URL;

public interface URLDataProvider {
    URL salvar(URL url);

    URL buscarPorUrlEncurtada(String urlEncurtada);
}
