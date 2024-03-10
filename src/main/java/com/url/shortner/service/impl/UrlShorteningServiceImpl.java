package com.url.shortner.service.impl;

import com.url.shortner.model.Url;
import com.url.shortner.model.UrlCreateRequest;
import com.url.shortner.repo.UrlRepository;
import com.url.shortner.service.UrlShorteningService;
import com.url.shortner.utilities.ShortenerUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {

    @Autowired
    UrlRepository repository;

    @Override
    public ResponseEntity<?> generateShortUrl(final UrlCreateRequest url) {
        Url urlToShorten = new Url();

        urlToShorten.setUrl(url.getOriginalUrl());
        urlToShorten.setShortenedUrl(ShortenerUtilities.getShortenedUrl(urlToShorten.getUrl()));
        urlToShorten.setCreatedDate(LocalDateTime.now());
        urlToShorten.setExpiryDate(LocalDateTime.now().plusDays(2));
        Url savedUrl = this.repository.save(urlToShorten);

        return ResponseEntity.ok(savedUrl);
    }



    @Override
    public Url getShortenedUrl() {
        return null;
    }

    @Override
    public void deleteUrl() {

    }
}
