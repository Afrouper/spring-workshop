package de.repmek.springworkshop.annotations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void sayHello() {
        String hello = personService.sayHello("Chris");
        assertEquals("Hello Chris", hello);
    }
}