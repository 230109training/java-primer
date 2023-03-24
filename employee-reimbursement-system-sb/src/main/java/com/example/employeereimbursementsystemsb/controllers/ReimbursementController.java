package com.example.employeereimbursementsystemsb.controllers;

import com.example.employeereimbursementsystemsb.dtos.MessageDTO;
import com.example.employeereimbursementsystemsb.exceptions.InvalidParameterException;
import com.example.employeereimbursementsystemsb.exceptions.NotFoundException;
import com.example.employeereimbursementsystemsb.exceptions.UnauthorizedException;
import com.example.employeereimbursementsystemsb.models.Reimbursement;
import com.example.employeereimbursementsystemsb.services.ReimbursementService;
import com.example.employeereimbursementsystemsb.utilities.JWTUtility;
import com.example.employeereimbursementsystemsb.utilities.UserPayload;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReimbursementController {

    private ReimbursementService reimbursementService;

    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    // Add reimbursement
    @PostMapping(path = "/reimbursements")
    public ResponseEntity<MessageDTO> addReimbursement(@RequestHeader("Authorization") String authHeader, @RequestBody Reimbursement reimbursementInfo) {
        // ["Bearer", "<token"]
        UserPayload payload = JWTUtility.verifyTokenAndReturnPayload(authHeader.split(" ")[1]);

        try {
            this.reimbursementService.addReimbursement(reimbursementInfo, payload);

            return ResponseEntity.status(201).body(new MessageDTO("Reimbursement Submitted!"));
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(401).body(new MessageDTO(e.getMessage()));
        }
    }

    @GetMapping(path = "/reimbursements")
    public ResponseEntity<Object> getReimbursements(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.split(" ")[1];
        UserPayload payload = JWTUtility.verifyTokenAndReturnPayload(token);

        List<Reimbursement> reimbursements = null;
        try {
            reimbursements = this.reimbursementService.getReimbursements(payload);
            return ResponseEntity.ok(reimbursements);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(401).body(new MessageDTO(e.getMessage()));
        }
    }

    @PatchMapping(path = "/reimbursements/{id}/status")
    public ResponseEntity<MessageDTO> resolveReimbursement(@PathVariable("id") String id, @RequestHeader("Authorization") String authHeader, @RequestBody Reimbursement statusInfo) {
        String token = authHeader.split(" ")[1];

        UserPayload payload = JWTUtility.verifyTokenAndReturnPayload(token);
        int intId = Integer.parseInt(id);
        String status = statusInfo.getStatus();

        try {
            this.reimbursementService.resolveReimbursement(intId, status, payload);

            return ResponseEntity.ok(new MessageDTO("Reimbursement status updated"));
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(401).body(new MessageDTO(e.getMessage()));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body(new MessageDTO(e.getMessage()));
        }
    }

}
