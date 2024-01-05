package de.repmek.springworkshop.restclient;

import de.repmek.springworkshop.restclient.vo.HttpBinJso;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HttpBinClientAsCode {

    private final RestClient restClient;

    public HttpBinClientAsCode() {
        restClient = RestClient.create("https://httpbin.org");
    }

    public String get() {
        return restClient
                .get()
                .uri("/get")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }

    public HttpBinJso getJson() {
        return restClient
                .get()
                .uri("/get")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(HttpBinJso.class);
    }
}
