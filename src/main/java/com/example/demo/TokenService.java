package com.example.demo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenService {

    public static final String BEARER = "Bearer";
    public static final String TOKEN_CACHE = "token-cache";

    @Cacheable(value = TOKEN_CACHE)
    public String generateToken() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String token = "hash.hash.hash." + new Random().nextInt(3);
        System.out.println("---------------------");
        System.out.println("GENERATING " + token);
        System.out.println("---------------------");

        TokenDto tokenDto = new TokenDto(token, 600, BEARER);
        return tokenDto.getTokenType() + " " + tokenDto.getAccessToken();
    }

    @CacheEvict(value = TOKEN_CACHE, allEntries = true)
    public void deleteCacheTokens() {
        System.out.println("----------------------------");
        System.out.println("DELETE OLD TOKEN");
        System.out.println("----------------------------");
    }
}
