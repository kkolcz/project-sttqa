package com.sttqa.ping.domain;

public record PingResult(String message) {

    public static PingResult pong() {
        return new PingResult("pong");
    }
}
