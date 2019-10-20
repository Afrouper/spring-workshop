package de.repmek.springworkshop.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ValidationApplication.class);
    }
}
