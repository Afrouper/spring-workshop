package de.repmek.springworkshop.scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class ScopeController {

    @Autowired
    private ObjectFactory<Person> person;

    @GetMapping(path = "/addName/{name}")
    public String setName(@PathVariable("name") String name) {
        person.getObject().setName(name);
        return "created";
    }

    @GetMapping(path = "getPerson")
    public Person getPerson() {
        return person.getObject();
    }
}
