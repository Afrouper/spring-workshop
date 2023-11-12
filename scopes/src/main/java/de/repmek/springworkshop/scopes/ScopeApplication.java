package de.repmek.springworkshop.scopes;

import de.repmek.springworkshop.scopes.tabScope.TabScopeImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ScopeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScopeApplication.class);
    }

    @Bean
    public static CustomScopeConfigurer customScopes(ObjectFactory<HttpServletRequest> requestObjectFactory) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("tab", new TabScopeImpl(requestObjectFactory));

        return configurer;
    }
}
