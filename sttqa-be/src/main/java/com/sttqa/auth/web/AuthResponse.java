package com.sttqa.auth.web;

public record AuthResponse(String token, String tokenType, long expiresIn) {
}
