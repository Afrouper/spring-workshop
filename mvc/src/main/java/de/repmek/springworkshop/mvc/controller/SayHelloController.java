package de.repmek.springworkshop.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SayHelloController {

    @GetMapping("/sayHello")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Lutz") String name, Model model) {
        model.addAttribute("name", name);
        return "sayHello";
    }
}
