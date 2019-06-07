package com.example.springjwt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {


    @GetMapping("/public/welcome")
    public String welcome() {
        String saludo = LocalDateTime.now().toString();
        return "Public Welcome! : " + saludo;
    }

    @GetMapping("/private/welcome")
    public String privateWelcome() {
        String saludo = LocalDateTime.now().toString();
        return "Private Welcome! : " + saludo;
    }


    @GetMapping("/v1/test/rest/hello_A")
    public String hello() {
        String saludo = LocalDateTime.now().toString();
        return "Hi, the times is: " + saludo;
    }

    @GetMapping("/v1/test/rest/hello_B")
    public String hello2() {
        String saludo = LocalDateTime.now().toString();
        return "Hi, the times is: " + saludo;
    }

    @GetMapping("/third/branch")
    public String nada() {
        return "Nnthing Here!!";
    }


    @GetMapping("/secondary/hello")
    public String secondary() {
        String saludo = LocalDateTime.now().toString();
        return "Hola, la hora es: " + saludo;
    }

}
