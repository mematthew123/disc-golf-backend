package com.example.discgolf.repository;

import com.example.discgolf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
