package de.repmek.springworkshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServer.class);

    public static void main(String[] args) {
        LOGGER.info("Start Spring Boot RestServer");
        SpringApplication.run(RestServer.class);
    }
}
