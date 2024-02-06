package com.url.shortner.controller;

import com.url.shortner.model.Url;
import com.url.shortner.repo.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("/getShortenedUrl")
    public ResponseEntity<?> getShortenedUrl(){
        return ResponseEntity.ok(this.urlRepository.findAll());
    }

    @PostMapping("/createShortUrl")
    public ResponseEntity<?> createShortUrl(@RequestBody Url urlInfo){
        Url url = this.urlRepository.save(urlInfo);
        return ResponseEntity.ok(url);
    }
}
