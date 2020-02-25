package br.com.azinformatica.url.application.factory;

import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirURLUseCase;
import br.com.azinformatica.url.domain.usecase.InserirURLUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirURLFactory {

    @Autowired
    private URLDataProvider urlDataProvider;

    @Bean
    public InserirURLUseCase criarInserirURLUseCase(){
        return new InserirURLUseCaseImpl(urlDataProvider);
    }

}
