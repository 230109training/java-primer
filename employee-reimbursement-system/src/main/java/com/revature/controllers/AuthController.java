package com.revature.controllers;

import com.revature.dto.MessageDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.UsernameAlreadyTakenException;
import com.revature.model.User;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AuthController {
    private UserService userService = new UserService();

    private Handler registerUser = (ctx) -> {
        User userToAdd = ctx.bodyAsClass(User.class);

        try {
            userService.registerNewUser(userToAdd);
            ctx.json(new MessageDTO("Successfully registered user"));
            ctx.status(201); // 201 Created
            return;
        } catch (UsernameAlreadyTakenException | InvalidParameterException e) {
            ctx.json(new MessageDTO(e.getMessage()));
            ctx.status(400); // 400 Bad Request
            return;
        }
    };

    public void registerEndpoints(Javalin app) {
        app.post("/users", registerUser);
    }
}
