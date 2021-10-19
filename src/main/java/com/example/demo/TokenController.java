package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        String s = tokenService.generateToken();
        System.out.println(s);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/delete")
    public ResponseEntity<Void> deleteToken() {
        tokenService.deleteCacheTokens();
        return ResponseEntity.ok().build();
    }
}
