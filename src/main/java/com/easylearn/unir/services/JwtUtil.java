package com.easylearn.unir.services;

import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtUtil {
    String generateToken(String username, Map<String, Object> exclaims);
    Claims extractClaims(String token);
    String extractUsername(String token);
    boolean isTokenExpired(String token);
    boolean validateToken(String token, String username);
}
