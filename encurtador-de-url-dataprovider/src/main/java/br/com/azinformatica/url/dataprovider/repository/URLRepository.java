package br.com.azinformatica.url.dataprovider.repository;


import br.com.azinformatica.url.dataprovider.entity.URLJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLRepository extends JpaRepository<URLJpa, Long> {
    Optional<URLJpa>  findURLJpaByUrlEncurtada(String urlEncurtada);
}
