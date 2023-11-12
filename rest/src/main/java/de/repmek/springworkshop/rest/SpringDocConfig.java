package de.repmek.springworkshop.rest;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//FIXME:
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Simple Spring REST API").version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/**")
                .build();
    }

    /**
     * FIXME - transfer from swagger2
     *
     *     public Docket api() {
     *         return new Docket(DocumentationType.SWAGGER_2)
     *                 .select()
     *                 .apis(RequestHandlerSelectors.any())
     *                 .paths(PathSelectors.any())
     *                 .build()
     *                 .pathMapping("/")
     *                 .apiInfo(apiInfo());
     *     }
     *
     *     private ApiInfo apiInfo() {
     *         ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
     *         return apiInfoBuilder.title("REST Server API")
     *                 .description("Workshop example of API documentation with swagger")
     *                 .version("1.0.0")
     *                 .contact(new Contact("John Doe", "http://example.com", "john.doe@example.com"))
     *                 .license("APACHE LICENSE, VERSION 2.0")
     *                 .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
     *                 .build();
     *     }
     */
}
