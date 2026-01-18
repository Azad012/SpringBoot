package com.azad.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class Greeting {

    @GetMapping("/get")
    public String greeting(){
        return " Hi, I'm from backend";
    }
}
