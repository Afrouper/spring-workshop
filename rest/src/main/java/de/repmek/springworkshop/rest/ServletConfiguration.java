package de.repmek.springworkshop.rest;

import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean<HttpServlet> servletRegistration(ApplicationContext context) {
        ServletRegistrationBean<HttpServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(context.getBean(HelloServlet.class));
        servletRegistrationBean.addUrlMappings("/helloServlet/*");
        return servletRegistrationBean;
    }
}
