package br.com.azinformatica.url.utils;

import br.com.azinformatica.url.domain.port.utils.GeradorDeUrl;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeradorDeUrlImpl implements GeradorDeUrl {

    private final String alfabeto = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String geraUrl() {
        int tamanho = alfabeto.length();
        int contador = 0;
        StringBuilder str = new StringBuilder();
        while (contador < 6) {
            str.insert(0, alfabeto.charAt(new Random().nextInt(tamanho)));
            contador++;
        }
        return str.toString();
    }
}
