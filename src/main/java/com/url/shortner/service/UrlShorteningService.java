package com.url.shortner.service;

import com.url.shortner.model.Url;
import com.url.shortner.model.UrlCreateRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface UrlShorteningService {
    public ResponseEntity<?> generateShortUrl(UrlCreateRequest url);
    public Url getShortenedUrl();
    public void deleteUrl();
    public ResponseEntity<?> redirectToOriginalUrl(String shortLink, HttpServletResponse response);
    public ResponseEntity<?> getAllUrls();
}
