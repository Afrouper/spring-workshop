package de.repmek.springworkshop.scopes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScopeControllerTest {

    @LocalServerPort
    private int port;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testScopes() throws Exception {
        UUID scope1 = UUID.randomUUID();
        UUID scope2 = UUID.randomUUID();

        HttpClient httpClient1 = createHttpClient();
        HttpClient httpClient2 = createHttpClient();

        HttpRequest creationRequest1 = createCreationRequest(scope1, "Chris");
        HttpRequest creationRequest2 = createCreationRequest(scope2, "Horst");

        HttpResponse<String> creationResponse1 = sendAndCheckCreationRequest(httpClient1, creationRequest1);
        HttpResponse<String> creationResponse2 = sendAndCheckCreationRequest(httpClient2, creationRequest2);

        HttpRequest getPersonRequest1 = createPersonRequest(scope1);
        HttpRequest getPersonRequest2 = createPersonRequest(scope2);

        Person person1 = getPerson(httpClient1, getPersonRequest1);
        Person person2 = getPerson(httpClient2, getPersonRequest2);

        assertEquals("Chris", person1.getName());
        assertEquals("Horst", person2.getName());
    }

    private Person getPerson(HttpClient httpClient, HttpRequest request) throws Exception {
        HttpResponse<String> personResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        String personJson = personResponse.body();
        assertEquals(200, personResponse.statusCode());
        return objectMapper.readValue(personJson, Person.class);
    }

    private HttpResponse<String> sendAndCheckCreationRequest(HttpClient httpClient, HttpRequest request) throws Exception {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        assertEquals(200, response.statusCode());
        assertEquals("created", response.body());
        return response;
    }

    private HttpRequest createPersonRequest(UUID scope1) {
        return HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/getPerson"))
                .header("X-Scope-tabId", scope1.toString())
                .GET()
                .build();
    }

    private HttpRequest createCreationRequest(UUID scope1, String name) {
        return HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/addName/" + name))
                .timeout(Duration.ofMinutes(1))
                .header("X-Scope-tabId", scope1.toString())
                .GET()
                .build();
    }

    private HttpClient createHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .cookieHandler(new CookieManager())
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }
}