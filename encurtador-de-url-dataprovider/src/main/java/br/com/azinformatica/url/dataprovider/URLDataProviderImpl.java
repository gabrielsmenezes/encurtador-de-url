package br.com.azinformatica.url.dataprovider;

import br.com.azinformatica.url.dataprovider.entity.URLJpa;
import br.com.azinformatica.url.dataprovider.repository.URLRepository;
import br.com.azinformatica.url.domain.entity.URL;
import br.com.azinformatica.url.domain.port.dataprovider.URLDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class URLDataProviderImpl implements URLDataProvider {

    @Autowired
    private URLRepository urlRepository;

    private URL findById(Long id){
        URLJpa urlJpa = urlRepository.findById(id).get();
        return urlJpa.to();
    }

    @Override
    public URL salvar(URL url) {
        URLJpa unsaved = new URLJpa();
        unsaved.from(url);
        URLJpa saved = urlRepository.save(unsaved);
        return saved.to();
    }

    @Override
    public URL buscarPorUrlEncurtada(String urlEncurtada) {
        URLJpa urlJpa = urlRepository.findURLJpaByUrlEncurtada(urlEncurtada).orElse(null);
        return Objects.isNull(urlJpa) ? null : urlJpa.to();
    }
}
