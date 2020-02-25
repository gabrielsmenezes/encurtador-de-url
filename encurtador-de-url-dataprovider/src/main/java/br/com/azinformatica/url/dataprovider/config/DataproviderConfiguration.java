package br.com.azinformatica.url.dataprovider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.azinformatica.url.dataprovider.repository")
public class DataproviderConfiguration {
}
