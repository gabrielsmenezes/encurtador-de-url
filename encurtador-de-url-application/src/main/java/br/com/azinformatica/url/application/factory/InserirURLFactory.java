package br.com.azinformatica.url.application.factory;

import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirUrlUseCase;
import br.com.azinformatica.url.domain.port.utils.GeradorDeUrl;
import br.com.azinformatica.url.domain.usecase.InserirUrlUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirURLFactory {

    @Autowired
    private URLDataProvider urlDataProvider;

    @Autowired
    private GeradorDeUrl geradorDeUrl;

    @Bean
    public InserirUrlUseCase criarInserirURLUseCase(){
        return new InserirUrlUseCaseImpl(urlDataProvider, geradorDeUrl);
    }

}
