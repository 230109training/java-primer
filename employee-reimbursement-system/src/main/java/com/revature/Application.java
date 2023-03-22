package com.revature;

import com.revature.controllers.AuthController;
import com.revature.dto.MessageDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.model.User;
import com.revature.services.UserService;
import io.javalin.Javalin;

public class Application {
    // POST /users: register
    // POST /login: login
    // GET /reimbursements: view reimbursements
    // PATCH /reimbursements/{id}/status: update status of reimbursement

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/health", (ctx) -> {
            ctx.json(new MessageDTO("Server is online"));
        });

        AuthController authController = new AuthController();
        authController.registerEndpoints(app);

        app.start(8080);
    }

}
