package com.revature.dao;

import com.revature.model.Reimbursement;
import com.revature.utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementDAO {

    public void addReimbursement(Reimbursement reimbursement) throws SQLException {
        // JDBC logic for adding to database
        Connection con = ConnectionUtility.getConnection();

        PreparedStatement pstmt = con.prepareStatement("INSERT INTO reimbursements (description, submitter) VALUES (?, ?)");
        pstmt.setString(1, reimbursement.getDescription());
        pstmt.setString(2, reimbursement.getSubmitter());

        pstmt.executeUpdate();
    }

}
