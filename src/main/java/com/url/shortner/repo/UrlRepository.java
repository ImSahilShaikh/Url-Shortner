package com.url.shortner.repo;

import com.url.shortner.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url,Integer> {
    Url findByShortenedUrl(String shortenedUrl);
}
