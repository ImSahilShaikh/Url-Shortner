package com.url.shortner.controller;

import com.url.shortner.constants.ControllerConstants;
import com.url.shortner.model.UrlCreateRequest;
import com.url.shortner.service.UrlShorteningService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenController {

    @Autowired
    UrlShorteningService shorteningService;

    @GetMapping(ControllerConstants.GET_ALL_URLS)
    public ResponseEntity<?> getAllUrls(){
        return shorteningService.getAllUrls();
    }

    @PostMapping(ControllerConstants.CREATE_SHORT_URL)
    public ResponseEntity<?> createShortUrl(@RequestBody UrlCreateRequest urlRequest){
        return shorteningService.generateShortUrl(urlRequest);
    }

    @GetMapping(ControllerConstants.REDIRECT_TO_ORIGINAL_URL)
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) {
        return shorteningService.redirectToOriginalUrl(shortLink,response);
    }
}
