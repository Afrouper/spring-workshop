package de.repmek.springworkshop.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}

	public AnnotationsApplication() {
		LOGGER.info("Created Spring Application!");
	}
}
