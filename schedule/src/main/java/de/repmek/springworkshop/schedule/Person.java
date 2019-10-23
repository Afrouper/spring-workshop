package de.repmek.springworkshop.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    @Async
    public void logName() throws Exception {
        LOGGER.info("Before logName");

        Thread.sleep(2000);
        LOGGER.info("Hello. I am Chris.");

        LOGGER.info("After logName");
    }

    @Async
    public CompletableFuture<String> sayHello() {
        return CompletableFuture.supplyAsync(Person::lazyHello);
    }

    private static String lazyHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Error setting thread to sleep.", e);
        }
        return "Chris";
    }
}
