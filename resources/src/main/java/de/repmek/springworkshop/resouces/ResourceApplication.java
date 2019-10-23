package de.repmek.springworkshop.resouces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Starting {}", ResourceApplication.class.getSimpleName());
    }
}
