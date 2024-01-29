package com.url.shortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenController {
    @GetMapping("/getShortenedUrl")
    public String getShortenedUrl(){
        //TODO - to add URL fetch logic from a db (nosql is planned to be used)
        String url = "someValue";
        //TODO - must return Http entity to handle error codes
        return url;
    }

    @PostMapping("/createShortUrl")
    public void createShortUrl(@RequestBody String urlInfo){
        //TODO - must return Http entity to handle error codes
    }
}
