package com.url.shortner.service;

import com.url.shortner.model.Url;
import org.springframework.stereotype.Service;

@Service
public interface UrlShorteningService {
    public Url generateShortUrl();
    public Url getShortenedUrl();
    public void deleteUrl();
}
