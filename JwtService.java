package com.example2.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final String secret = "mysecretkeymysecretkeymysecretkey12";
    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    private Key getSignKey()
    {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSignKey(),SignatureAlgorithm.HS256)
                .compact();
    }


}
