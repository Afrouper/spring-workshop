package de.repmek.springworkshop.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_TIME;

    @Scheduled(fixedRate = 2000)
    public void currentDate() {
        LocalTime now = LocalTime.now();
        LOGGER.info("Current time: {}", now.format(dateTimeFormatter));
    }
}
