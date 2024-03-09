package com.url.shortner.controller;

import com.url.shortner.ShortenerUtilities;
import com.url.shortner.constants.ControllerConstants;
import com.url.shortner.model.Url;
import com.url.shortner.repo.UrlRepository;
import com.url.shortner.service.UrlShorteningService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
public class ShortenController {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    UrlShorteningService shorteningService;

    @GetMapping(ControllerConstants.GET_ALL_URLS)
    public ResponseEntity<?> getShortenedUrl(){
        return ResponseEntity.ok(this.urlRepository.findAll());
    }

    @PostMapping(ControllerConstants.CREATE_SHORT_URL)
    public ResponseEntity<?> createShortUrl(@RequestBody Url urlInfo){
        System.out.println(shorteningService.generateShortUrl(urlInfo));
        urlInfo.setShortenedUrl(ShortenerUtilities.getShortenedUrl(urlInfo.getUrl()));
        urlInfo.setCreatedDate(LocalDateTime.now());
        urlInfo.setExpiryDate(LocalDateTime.now().plusDays(2));
        Url url = this.urlRepository.save(urlInfo);

        return ResponseEntity.ok(url);
    }

    @GetMapping(ControllerConstants.REDIRECT_TO_ORIGINAL_URL)
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
        Url urlToRedirect = this.urlRepository.findByShortenedUrl(shortLink);
        response.sendRedirect(urlToRedirect.getUrl());
        return null;
    }
}
