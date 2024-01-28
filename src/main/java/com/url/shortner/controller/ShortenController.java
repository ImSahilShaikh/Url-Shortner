package com.url.shortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenController {
    @GetMapping("/hello")
    public String helloController(){
        return "Sahil";
    }
}
