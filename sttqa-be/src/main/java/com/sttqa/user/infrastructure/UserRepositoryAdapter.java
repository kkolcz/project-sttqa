package com.sttqa.user.infrastructure;

import com.sttqa.user.application.UserRepository;
import com.sttqa.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.jpaUserRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.jpaUserRepository.existsByUsername(username);
    }

    @Override
    public User save(User user) {
        return this.jpaUserRepository.save(user);
    }
}
