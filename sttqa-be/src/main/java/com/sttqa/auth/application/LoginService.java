package com.sttqa.auth.application;

import com.sttqa.security.JwtTokenService;
import com.sttqa.user.application.UserRepository;
import com.sttqa.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public LoginResult login(LoginCommand command) {
        User user = userRepository.findByUsername(command.username())
                .filter(u -> passwordEncoder.matches(command.password(), u.getPassword()))
                .orElseThrow(InvalidCredentialsException::new);
        return new LoginResult(jwtTokenService.generate(user), jwtTokenService.expiresInSeconds());
    }
}
