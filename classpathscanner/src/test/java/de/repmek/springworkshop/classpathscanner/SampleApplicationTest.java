package de.repmek.springworkshop.classpathscanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(initializers = TestContextInitializer.class)
class SampleApplicationTest {

    @Autowired
    private SampleApplication sampleApplication;

    @Test
    void sayHello() {
        String hello = sampleApplication.sayHello("Chris");
        assertEquals("Hello Chris", hello);
    }
}