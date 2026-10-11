package com.sttqa.auth.application;

public interface LoginUseCase {
    LoginResult login(LoginCommand command);
}
