package com.next.user_service.utill;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.UUID;

public class JWTTokenGenarator {
    public String createJWt(String name, String password) {
        long expirationTimeMillis = 3 * 60 * 60 * 1000; // 3 hours in milliseconds

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // Calculate expiration time
        Date exp = new Date(nowMillis + expirationTimeMillis);

        return Jwts.builder()
                .claim("name", name)
                .claim("password", password)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .compact();
    }

    public boolean validateToken(String authToken) {
        if (authToken != null) {
            String token = authToken.substring(7);
            return true;
        } else {
            return false;
        }
    }
}
