package br.com.azinformatica.url.dataprovider.entity;

import br.com.azinformatica.url.domain.entity.URL;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "URL_JPA")
@SequenceGenerator(name = "SEQ_URL_JPA", sequenceName = "SEQ_URL_JPA")
public class URLJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_URL_JPA")
    private Long id;

    @Column(name = "UJ_URL_ENCURTADA")
    private String urlEncurtada;

    @Column(name = "UJ_URL_NAO_ENCURTADA")
    private String urlNaoEncurtada;

    public URL to() {
        return URL
                .builder()
                .id(this.id)
                .urlEncurtada(this.urlEncurtada)
                .urlNaoEncurtada(this.urlNaoEncurtada)
                .build();
    }

    public void from(URL url) {
        this.urlNaoEncurtada = url.getUrlNaoEncurtada();
        this.urlEncurtada = url.getUrlEncurtada();
    }
}
