package com.basicSpringSecurity.springSecurity.controller;

import com.basicSpringSecurity.springSecurity.domain.RegisterUserRequest;
import com.basicSpringSecurity.springSecurity.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {
    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<UUID> registerUser(@RequestParam String email, @RequestParam String password){
        UUID response = registrationService.registerUser(email,password);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
