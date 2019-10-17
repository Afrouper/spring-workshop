package de.repmek.springworkshop.rest;

import de.repmek.springworkshop.rest.vo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContoller {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestContoller.class);

    @GetMapping(path = "/hello/{name}/{age}")
    public Person sayHello(@PathVariable("name") String name, @PathVariable("age") int age) {
        LOGGER.debug("Method sayHello called with name {} and age {}", name, age);
        return new Person(name, age);
    }
}
