package com.url.shortner.model;


public class UrlCreateRequest {
    String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UrlCreateRequest{");
        sb.append("originalUrl='").append(originalUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
