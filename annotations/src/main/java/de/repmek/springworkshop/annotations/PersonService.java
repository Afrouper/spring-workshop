package de.repmek.springworkshop.annotations;

import de.repmek.springworkshop.annotations.annotation.CustomAnnotation;

@CustomAnnotation
public class PersonService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
