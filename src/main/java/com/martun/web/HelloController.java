package com.martun.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    private String getHelloWorld(){
        return "Hello World";
    }

}
