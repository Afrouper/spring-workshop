package de.repmek.springworkshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // Optional; Swagger API Doc: http://localhost:8080/swagger-ui.html
public class RestServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServer.class);

    public static void main(String[] args) {
        LOGGER.info("Start Spring Boot RestServer");
        SpringApplication.run(RestServer.class);
    }

    /**
     * Optional
     * Definition and simple configuration for swagger
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        ApiInfo apiInfo = apiInfoBuilder.title("REST Server API")
                .description("Workshop example of API documentation with swagger")
                .version("1.0.0")
                .contact(new Contact("John Doe", "http://example.com", "john.doe@example.com"))
                .license("APACHE LICENSE, VERSION 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
        return apiInfo;
    }
}
