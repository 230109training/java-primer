package com.example.employeereimbursementsystemsb.services;

import com.example.employeereimbursementsystemsb.daos.UserRepository;
import com.example.employeereimbursementsystemsb.exceptions.LoginException;
import com.example.employeereimbursementsystemsb.exceptions.UniqueViolationException;
import com.example.employeereimbursementsystemsb.models.User;
import com.example.employeereimbursementsystemsb.utilities.JWTUtility;
import com.example.employeereimbursementsystemsb.utilities.UserPayload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Configure AuthService as a Spring Bean (Inversion of Control)
public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Return JWT as a string
    public String login(String username, String password) throws LoginException {
        Optional<User> userOpt = this.userRepository.findByUsernameAndPassword(username, password);

        // Retrieve the user object from the Optional, or if one does not exist, throw LoginException
        User user = userOpt.orElseThrow(() -> new LoginException("Invalid credentials"));

        UserPayload payload = new UserPayload(user.getUsername(), user.getRole());

        return JWTUtility.createToken(payload);
    }

    // Service layer is for business logic
    // 1. Check if username is already taken
    // 2. Check if email is already taken
    // -> Throw exception if they are
    public void register(User registrationInfo) throws UniqueViolationException {

        // Check if username is already taken
        Optional<User> userOpt = this.userRepository.findById(registrationInfo.getUsername());
        if (userOpt.isPresent()) {
            throw new UniqueViolationException("Username is already taken");
        }

        // Check if email is already taken
        Optional<User> userOpt2 = this.userRepository.findByEmail(registrationInfo.getEmail());

        if (userOpt2.isPresent()) {
            throw new UniqueViolationException("Email is already taken");
        }

        registrationInfo.setRole("employee");
        // Save the user
        this.userRepository.save(registrationInfo);
    }

}
