package de.repmek.springworkshop.mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/calledName")
    public Person setCalledName(@RequestBody(required = false) Optional<Person> person) {
        Person p = person.orElse(new Person());
        p.setCalledName(p.getVorname() + " " + p.getName());
        return p;
    }
}
