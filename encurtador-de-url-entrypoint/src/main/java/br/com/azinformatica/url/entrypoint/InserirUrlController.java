package br.com.azinformatica.url.entrypoint;

import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirUrlRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.InserirUrlResponse;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.InserirUrlUseCase;
import br.com.azinformatica.url.entrypoint.factory.InserirUrlRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/urls")
public class InserirUrlController {

    @Autowired
    private InserirUrlRequestFactory inserirUrlRequestFactory;

    @Autowired
    private InserirUrlUseCase inserirURLUseCase;

    @PostMapping
    public ResponseEntity<?> inserirUrl(@RequestBody Map<String, Object> body){
        InserirUrlRequest request = inserirUrlRequestFactory.create(body);

        InserirUrlResponse response = inserirURLUseCase.execute(request);

        return ResponseEntity.ok(response);
    }
}
