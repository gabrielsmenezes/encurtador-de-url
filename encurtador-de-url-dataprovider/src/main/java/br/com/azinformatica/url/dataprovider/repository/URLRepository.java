package br.com.azinformatica.url.dataprovider.repository;


import br.com.azinformatica.url.dataprovider.entity.URLJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URLJpa, Long> {
}
