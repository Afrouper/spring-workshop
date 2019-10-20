package de.repmek.springworkshop.resouces;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Component
public class ResourceBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceBean.class);

    private static final String RESOURCE_NAME = "data/dataFile.txt";

    @Value(RESOURCE_NAME)
    private Resource dataFileResource;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ResourceLoader resourceLoader;

    public String getFileContentFromResource() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(dataFileResource.getFile());
        return read(fileInputStream);
    }

    public String getFileContentFromApplicationContext() throws IOException {
        Resource resource = applicationContext.getResource(RESOURCE_NAME);
        FileInputStream fileInputStream = new FileInputStream(resource.getFile());
        return read(fileInputStream);
    }

    public String getFileContentFromResourceLoader() throws Exception {
        Resource resource = resourceLoader.getResource(RESOURCE_NAME);
        FileInputStream fileInputStream = new FileInputStream(resource.getFile());
        return read(fileInputStream);
    }

    private String read(InputStream inputStream) throws IOException {
        StringWriter sw = new StringWriter(64);
        try(inputStream) {
            IOUtils.copy(inputStream, sw, StandardCharsets.UTF_8.name());
            return sw.toString();
        }
    }
}
