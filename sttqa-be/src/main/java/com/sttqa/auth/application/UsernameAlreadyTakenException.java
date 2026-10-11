package com.sttqa.auth.application;

public class UsernameAlreadyTakenException extends RuntimeException {
    public UsernameAlreadyTakenException(String username) {
        super("Username is already taken" + username);
    }
}
