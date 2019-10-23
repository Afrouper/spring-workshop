package de.repmek.springworkshop.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
public class ScheduleApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleApplication.class);

	@Autowired
	private ScheduledTask scheduledTask;

	@Autowired
	private Person person;

	@Autowired
	private AddressService addressService;

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Starting Scheduling sample");

		person.logName();

		LOGGER.info("Try to say hello to person.");
		CompletableFuture<String> future = person.sayHello();
		LOGGER.info("Person said hello: {}", future.getNow("No hello :-("));
		Thread.sleep(2000);
		LOGGER.info("Person said hello - next try: {}", future.getNow("No hello :-("));

		LOGGER.info("Call PLZ - Ort: {}", addressService.getOrt("20095"));
		LOGGER.info("Call PLZ - Ort: {}", addressService.getOrt("20095"));
		LOGGER.info("Call PLZ - Ort: {}", addressService.getOrt("20095"));
		LOGGER.info("Call PLZ - Ort: {}", addressService.getOrt("20095"));

		Thread.sleep(5000);
		SpringApplication.exit(applicationContext);
	}
}
