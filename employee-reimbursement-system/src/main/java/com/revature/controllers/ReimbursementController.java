package com.revature.controllers;

import com.revature.dto.MessageDTO;
import com.revature.exceptions.UnauthorizedException;
import com.revature.model.Reimbursement;
import com.revature.model.UserPayload;
import com.revature.services.ReimbursementService;
import com.revature.utility.JWTUtility;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController {

    private ReimbursementService reimbService = new ReimbursementService();

    private Handler addReimbursement = (ctx) -> {
        Reimbursement reimbursementToAdd = ctx.bodyAsClass(Reimbursement.class);

        try {
            String authHeader = ctx.header("Authorization");
            String token = authHeader.split(" ")[1];
            UserPayload payload = JWTUtility.verifyTokenAndReturnPayload(token);

            reimbService.addReimbursement(reimbursementToAdd, payload);
        } catch(UnauthorizedException e) {
            ctx.json(new MessageDTO(e.getMessage()));
            ctx.status(401); // 401 Unauthorized
        }
    };

    public void registerEndpoints(Javalin app) {
        // Map endpoints here
        app.post("/reimbursements", addReimbursement);
    }

}
