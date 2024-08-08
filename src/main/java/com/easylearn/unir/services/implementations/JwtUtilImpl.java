package com.easylearn.unir.services.implementations;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtilImpl {

    private final String secretKey = "'9F5DBA4DA5EA9C72AB0313DCEAFB4540874AC9508902895B6ABC0C0FE70EC741'";

    private final long expiration = 86400000;

    public String generateToken(String username, Map<String, Object> exclaims) {
        System.out.println("Hasta aqui todo bien"+"    "+ secretKey+"     "+ expiration);
        return Jwts.builder()
                .claims(exclaims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration ))
                .signWith(getSignedKey())
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignedKey())
                .build().parseSignedClaims(token).getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
    private Key getSignedKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }
}
