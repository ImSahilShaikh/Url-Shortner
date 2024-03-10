package com.url.shortner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.url.shortner.constants.PropertyConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = PropertyConstants.DB_COLLECTION_NAME)
public class Url {
    @Id
    private String urlId;
    private String url;
    private String shortenedUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expiryDate;

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
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
