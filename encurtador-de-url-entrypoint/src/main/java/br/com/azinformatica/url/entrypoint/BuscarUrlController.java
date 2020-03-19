package br.com.azinformatica.url.entrypoint;

import br.com.azinformatica.url.domain.port.entrypoint.dto.BuscarUrlRequest;
import br.com.azinformatica.url.domain.port.entrypoint.dto.BuscarUrlResponse;
import br.com.azinformatica.url.domain.port.entrypoint.usecase.BuscarUrlUseCase;
import br.com.azinformatica.url.entrypoint.factory.BuscarUrlRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/urls")
public class BuscarUrlController {

    @Autowired
    private BuscarUrlRequestFactory buscarUrlRequestFactory;

    @Autowired
    private BuscarUrlUseCase buscarUrlUseCase;

    @GetMapping("/{url}")
    public ResponseEntity<?> buscarUrl(@PathVariable String url){
        Map<String, String> body = new HashMap<>();
        body.put("urlEncurtada", url);
        BuscarUrlRequest request = buscarUrlRequestFactory.create(body);

        BuscarUrlResponse response = buscarUrlUseCase.execute(request);

        return ResponseEntity.ok(response);
    }
}
