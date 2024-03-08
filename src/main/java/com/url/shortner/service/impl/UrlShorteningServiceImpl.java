package com.url.shortner.service.impl;

import com.url.shortner.model.Url;
import com.url.shortner.service.UrlShorteningService;
import org.springframework.stereotype.Service;

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {
    @Override
    public String generateShortUrl(final Url url) {
        String encodedUrl = null;

        return encodedUrl;
    }

    @Override
    public Url getShortenedUrl() {
        return null;
    }

    @Override
    public void deleteUrl() {

    }
}
