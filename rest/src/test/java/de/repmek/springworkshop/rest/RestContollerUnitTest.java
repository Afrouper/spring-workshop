package de.repmek.springworkshop.rest;

import de.repmek.springworkshop.rest.vo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class RestContollerUnitTest {

    private RestContoller restContoller = new RestContoller();

    @Test
    void sayHello() {
        Person horst = restContoller.sayHello("Horst", 42);
        assertNotNull(horst);
        assertEquals("Horst", horst.getName());
        assertEquals(42, horst.getAge());
    }
}