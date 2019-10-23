package de.repmek.springworkshop.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Cacheable("plzOrtMapping")
    public String getOrt(String plz) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.error("Error setting thread to sleep.", e);
        }

        if("20095".equalsIgnoreCase(plz)) {
            return "Hamburg";
        }
        else if("50667".equalsIgnoreCase(plz)) {
            return "Cologne";
        }
        else return "unkown";
    }
}
