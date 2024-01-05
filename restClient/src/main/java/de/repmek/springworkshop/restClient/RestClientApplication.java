package de.repmek.springworkshop.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RestClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClientApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start Spring Boot RestClientServer");
        SpringApplication.run(RestClientApplication.class);
    }

    @Bean
    HttpBinClient restClientAsInterface() {
        RestClient restClient = RestClient.create("https://httpbin.org");
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return proxyFactory.createClient(HttpBinClient.class);
    }
}
