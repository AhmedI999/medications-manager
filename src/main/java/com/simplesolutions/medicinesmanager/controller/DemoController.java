package com.simplesolutions.medicinesmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/sayHello")
    public Response sayHello(@RequestParam(name = "name", required = false) String name){
        String greetMessage = name == null || name.isBlank() ? "Hello" : "Hello " + name;
        return new Response(greetMessage,
                List.of("Java", "JavaScript","Kotlin", "Python"),
                new Person("Ahmed"));
    }
    record Person(String name){}
    record Response(String greet, List<String> favProgrammingLanguages, Person person){}
}
