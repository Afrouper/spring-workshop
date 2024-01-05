package de.repmek.springworkshop.restclient;

import de.repmek.springworkshop.restclient.vo.HttpBinJso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HttpBinClientTest {

    @Autowired
    HttpBinClient client;

    @Autowired
    HttpBinClientAsCode clientAsCode;

    @Test
    void httpBinClient() {
        String json = client.get();
        assertNotNull(json);

        HttpBinJso jso = client.getJson();
        assertNotNull(jso);
        assertEquals("https://httpbin.org/get", jso.getUrl());
    }

    @Test
    void httpBinClientAsCode() {
        String json = clientAsCode.get();
        assertNotNull(json);

        HttpBinJso jso = clientAsCode.getJson();
        assertNotNull(jso);
        assertEquals("https://httpbin.org/get", jso.getUrl());
    }
}
