package com.url.shortner.service;

import com.url.shortner.model.Url;

public interface UrlShorteningService {
    public String generateShortUrl(Url url);
    public Url getShortenedUrl();
    public void deleteUrl();
}
