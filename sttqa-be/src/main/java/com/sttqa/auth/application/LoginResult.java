package com.sttqa.auth.application;

public record LoginResult(String token, long expiresIn) {
}
