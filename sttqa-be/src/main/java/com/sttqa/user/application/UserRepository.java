package com.sttqa.user.application;

import com.sttqa.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    User save(User user);

}
