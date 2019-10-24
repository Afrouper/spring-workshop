package de.repmek.springworkshop.rest;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

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
