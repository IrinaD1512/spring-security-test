package com.basicSpringSecurity.springSecurity.service;

import com.basicSpringSecurity.springSecurity.persistence.UserRepository;
import com.basicSpringSecurity.springSecurity.persistence.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID registerUser(String email, String plainTextPassword) {
        // Encrypt the plain-text password using your custom logic
        String encryptedPassword = passwordEncoder.encode(plainTextPassword);

        // Create a new user entity
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(encryptedPassword);

        // Save the user entity in the database
        userRepository.save(user);
        return user.getId();
    }
}
