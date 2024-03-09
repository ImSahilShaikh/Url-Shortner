package com.url.shortner;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class ShortenerUtilities {

    /**
     * @param url long url, example - https://github.com/ImSahilShaikh
     * @return encoded string
     */
    public static String getShortenedUrl(String url) {
        StringBuilder urlToEncode = new StringBuilder();
        LocalDateTime time = LocalDateTime.now();

        urlToEncode.append(url).append(time);

        return Hashing.murmur3_32_fixed().hashString(urlToEncode, StandardCharsets.UTF_8).toString();
    }
}
