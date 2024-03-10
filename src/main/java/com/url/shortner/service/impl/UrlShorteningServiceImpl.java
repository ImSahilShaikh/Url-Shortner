package com.url.shortner.service.impl;

import com.url.shortner.constants.PropertyConstants;
import com.url.shortner.model.Url;
import com.url.shortner.model.UrlCreateRequest;
import com.url.shortner.repo.UrlRepository;
import com.url.shortner.service.UrlShorteningService;
import com.url.shortner.utilities.ShortenerUtilities;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {

    @Autowired
    UrlRepository repository;

    @Autowired
    Environment environment;

    @Override
    public ResponseEntity<?> generateShortUrl(final UrlCreateRequest url) {
        Url urlToShorten = new Url();

        urlToShorten.setUrl(url.getOriginalUrl());
        urlToShorten.setShortenedUrl(ShortenerUtilities.getShortenedUrl(urlToShorten.getUrl()));
        urlToShorten.setCreatedDate(LocalDateTime.now());
        urlToShorten.setExpiryDate(LocalDateTime.now().plusDays(Long.parseLong(Objects.requireNonNull(environment.getProperty(PropertyConstants.URL_EXPIRY_DURATION_DAYS)))));
        Url savedUrl = this.repository.save(urlToShorten);

        return ResponseEntity.ok(savedUrl);
    }

    @Override
    public ResponseEntity<?> redirectToOriginalUrl(String shortLink, HttpServletResponse response) {
        Url urlToRedirect = this.repository.findByShortenedUrl(shortLink);
        try {
            response.sendRedirect(urlToRedirect.getUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getAllUrls() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @Override
    public Url getShortenedUrl() {
        return null;
    }

    @Override
    public void deleteUrl() {

    }
}
