package com.url.shortner.service.impl;

import com.url.shortner.constants.ErrorConstants;
import com.url.shortner.constants.PropertyConstants;
import com.url.shortner.model.Error;
import com.url.shortner.model.Url;
import com.url.shortner.model.UrlCreateRequest;
import com.url.shortner.repo.UrlRepository;
import com.url.shortner.service.UrlShorteningService;
import com.url.shortner.utilities.ShortenerUtilities;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlShorteningServiceImpl.class);

    @Autowired
    private UrlRepository repository;

    @Autowired
    private Environment environment;

    @Override
    public ResponseEntity<?> generateShortUrl(final UrlCreateRequest url) {
        try {
            Url urlToShorten = new Url();

            urlToShorten.setUrl(url.getOriginalUrl());
            urlToShorten.setShortenedUrl(ShortenerUtilities.getShortenedUrl(urlToShorten.getUrl()));
            urlToShorten.setCreatedDate(LocalDateTime.now());
            urlToShorten.setExpiryDate(LocalDateTime.now().plusDays(Long.parseLong(Objects.requireNonNull(environment.getProperty(PropertyConstants.URL_EXPIRY_DURATION_DAYS)))));
            Url savedUrl = this.repository.save(urlToShorten);

            return ResponseEntity.ok(savedUrl);
        } catch (Exception e) {
            LOGGER.trace("Something went wrong while saving the shortened URL: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ErrorConstants.DB_EC, ErrorConstants.DB_EM));
        }
    }

    @Override
    public ResponseEntity<?> redirectToOriginalUrl(String shortLink, HttpServletResponse response) {
        try {
            Url urlToRedirect = this.repository.findByShortenedUrl(shortLink);
            response.sendRedirect(urlToRedirect.getUrl());
        } catch (Exception e) {
            LOGGER.trace("Something went wrong while redirecting to the original URL :", e);
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(new Error(ErrorConstants.REDIRECT_EC, ErrorConstants.REDIRECT_EM));
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getAllUrls() {
        try {
            return ResponseEntity.ok(this.repository.findAll());
        } catch (Exception e) {
            LOGGER.trace("Unable to fetch all records : ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ErrorConstants.DB_EC, ErrorConstants.DB_EM));
        }

    }

    @Override
    public Url getShortenedUrl() {
        return null;
    }

    @Override
    public void deleteUrl() {

    }
}
