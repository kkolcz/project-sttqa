package com.sttqa.auth.application;

import com.sttqa.user.application.UserRepository;
import com.sttqa.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterUseCase {
    private static  final String DEFAULT_ROLE = "USER";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResult register(RegisterCommand command) {
        if (userRepository.existsByUsername(command.username())) {
            throw new UsernameAlreadyTakenException(command.username());
        }
        User user = new User(
                command.username(),
                passwordEncoder.encode(command.password()),
                DEFAULT_ROLE);
        User saved = userRepository.save(user);
        return new RegisterResult(saved.getId(), saved.getUsername());
    }
}
