package com.revature.services;

import com.revature.dao.ReimbursementDAO;
import com.revature.exceptions.UnauthorizedException;
import com.revature.model.Reimbursement;
import com.revature.model.UserPayload;

import java.sql.SQLException;

public class ReimbursementService {

    private ReimbursementDAO reimbDao = new ReimbursementDAO();

    public void addReimbursement(Reimbursement reimbursement, UserPayload payload) throws UnauthorizedException, SQLException {
        // If you are comparing string values, DO NOT use ==
        // == in Java is purely for comparing memory locations of objects or comparing primitive values
        // Strings are considered objects in Java, so doing memory address comparisons is definitely not
        // What we want
        // Use .equals to compare the actual values of 2 string objects
        if (!payload.getRole().equals("employee")) {
            throw new UnauthorizedException("Adding reimbursements is only allowed for users with an 'employee' role");
        }

        // Fill out validation logic
        // -> Throw exceptions as necessary

        // Set the submitter to be whoever is "logged in" using the JWT
        reimbursement.setSubmitter(payload.getUsername());

        // Call DAO to add to database
        reimbDao.addReimbursement(reimbursement);
    }

}
