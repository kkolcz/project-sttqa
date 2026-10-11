package com.sttqa.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@ConfigurationProperties(prefix = "security.jwt")
public record JwtProperties(String secret, String issuer, long accessTokenTtlSeconds) {
    public SecretKey secretKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(secret), "HmacSHA256");
    }
}
