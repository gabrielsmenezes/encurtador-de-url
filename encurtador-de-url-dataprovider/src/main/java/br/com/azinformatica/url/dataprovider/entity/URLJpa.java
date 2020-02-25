package br.com.azinformatica.url.dataprovider.entity;

import br.com.azinformatica.url.domain.entity.URL;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "MODELO_EMAIL")
@SequenceGenerator(name = "SEQ_MODELO_EMAIL", sequenceName = "SEQ_MODELO_EMAIL")
public class URLJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODELO_EMAIL")
    private Long id;

    private String urlEncurtada;

    private String urlNaoEncurtada;

    public URL to(){
        return URL
                .builder()
                .urlEncurtada(this.urlEncurtada)
                .urlNaoEncurtada(this.urlNaoEncurtada)
                .build();
    }
}
