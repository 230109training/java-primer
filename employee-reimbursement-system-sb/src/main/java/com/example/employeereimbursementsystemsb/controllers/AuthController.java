package com.example.employeereimbursementsystemsb.controllers;

import com.example.employeereimbursementsystemsb.dtos.LoginInfoDTO;
import com.example.employeereimbursementsystemsb.dtos.MessageDTO;
import com.example.employeereimbursementsystemsb.exceptions.LoginException;
import com.example.employeereimbursementsystemsb.exceptions.UniqueViolationException;
import com.example.employeereimbursementsystemsb.models.User;
import com.example.employeereimbursementsystemsb.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    // Constructor Injection (a type of dependency injection)
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Login
    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody User loginInfo) {
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        try {
            String token = this.authService.login(username, password);

            return ResponseEntity.ok(new LoginInfoDTO("Login successful!", token));
        } catch (LoginException e) {
            return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));
        }

    }

    // Registration
    @PostMapping(path = "/users")
    public ResponseEntity<MessageDTO> register(@RequestBody User registrationInfo) {
        try {
            this.authService.register(registrationInfo);

            return ResponseEntity.ok(new MessageDTO("User successfully registered!"));
        } catch (UniqueViolationException e) {
            return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));
        }
    }
}

