package com.revature.controllers;

import com.revature.dto.LoginSuccessDTO;
import com.revature.dto.MessageDTO;
import com.revature.exceptions.InvalidLoginException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.UsernameAlreadyTakenException;
import com.revature.model.User;
import com.revature.model.UserPayload;
import com.revature.services.UserService;
import com.revature.utility.JWTUtility;
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

    private Handler login = (ctx) -> {
        User loginInfo = ctx.bodyAsClass(User.class);

        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        try {
            String token = userService.login(username, password);

            ctx.json(new LoginSuccessDTO("Successfully logged in!", token));
            return;
        } catch (InvalidLoginException e) {
            ctx.json(new MessageDTO(e.getMessage()));
            ctx.status(400);
            return;
        }
    };

    public void registerEndpoints(Javalin app) {
        app.post("/users", registerUser);
        app.post("/login", login);

//        app.get("/test", (ctx) -> {
//            String authHeader = ctx.header("Authorization");
//            String token = authHeader.split(" ")[1];
//            System.out.println(token);
//
//            UserPayload payload = JWTUtility.verifyTokenAndReturnPayload(token);
//            System.out.println(payload.getUsername());
//            System.out.println(payload.getRole());
//        });
    }
}
