package com.url.shortner.service;

import com.url.shortner.model.Url;
import com.url.shortner.model.UrlCreateRequest;
import org.springframework.http.ResponseEntity;

public interface UrlShorteningService {
    public ResponseEntity<?> generateShortUrl(UrlCreateRequest url);
    public Url getShortenedUrl();
    public void deleteUrl();
}
