package de.repmek.springworkshop.classpathscanner;

import de.repmek.springworkshop.dynamicContext.BeanMarkerContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClasspathScannerApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathScannerApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplicationBuilder()
				.parent(ClasspathScannerApplication.class).initializers(new BeanMarkerContextInitializer("de.repmek.springworkshop.application"))
				.build(args);

		springApplication.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Started {} ", ClasspathScannerApplication.class.getSimpleName());
	}
}
