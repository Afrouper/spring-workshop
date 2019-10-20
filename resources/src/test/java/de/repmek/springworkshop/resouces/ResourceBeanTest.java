package de.repmek.springworkshop.resouces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceBeanTest {

    private static final String FILE_CONTENT = "File containing some text...";

    @Autowired
    private ResourceBean underTest;

    @Test
    public void getFileContentFromResource() throws Exception {
        assertEquals(FILE_CONTENT, underTest.getFileContentFromResource());
    }

    @Test
    public void getFileContentFromApplicationContext() throws Exception {
        assertEquals(FILE_CONTENT, underTest.getFileContentFromApplicationContext());
    }

    @Test
    public void getFileContentFromResourceLoader() throws Exception {
        assertEquals(FILE_CONTENT, underTest.getFileContentFromResource());
    }
}