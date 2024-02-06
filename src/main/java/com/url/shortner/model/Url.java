package com.url.shortner.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class Url {
    private String urlId;
    private String url;
    private String shortenedUrl;
    private String createdDate;
    private String expiryDate;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Url{");
        sb.append("urlId='").append(urlId).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", shortenedUrl='").append(shortenedUrl).append('\'');
        sb.append(", createdDate='").append(createdDate).append('\'');
        sb.append(", expiryDate='").append(expiryDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
