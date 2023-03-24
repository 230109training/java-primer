package com.example.employeereimbursementsystemsb.services;

import com.example.employeereimbursementsystemsb.daos.ReimbursementRepository;
import com.example.employeereimbursementsystemsb.daos.UserRepository;
import com.example.employeereimbursementsystemsb.exceptions.InvalidParameterException;
import com.example.employeereimbursementsystemsb.exceptions.NotFoundException;
import com.example.employeereimbursementsystemsb.exceptions.UnauthorizedException;
import com.example.employeereimbursementsystemsb.models.Reimbursement;
import com.example.employeereimbursementsystemsb.models.User;
import com.example.employeereimbursementsystemsb.utilities.UserPayload;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementService {

    private UserRepository userRepository;
    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(UserRepository userRepository, ReimbursementRepository reimbursementRepository) {
        this.userRepository = userRepository;
        this.reimbursementRepository = reimbursementRepository;
    }

    public void addReimbursement(Reimbursement reimbursementInfo, UserPayload payload) throws UnauthorizedException {
        // Check if user role is NOT "employee"
        if (!payload.getRole().equals("employee")) {
            throw new UnauthorizedException("Access Denied: Role must be 'employee'");
        }

        Reimbursement reimbursementToAdd = new Reimbursement();

        reimbursementToAdd.setAmount(reimbursementInfo.getAmount());
        reimbursementToAdd.setDescription(reimbursementInfo.getDescription());
        reimbursementToAdd.setStatus("pending");
        User submitter = userRepository.findById(payload.getUsername()).get();
        reimbursementToAdd.setSubmitter(submitter);

        reimbursementRepository.save(reimbursementToAdd);
    }

    public List<Reimbursement> getReimbursements(UserPayload payload) throws UnauthorizedException {
        if (payload.getRole().equals("employee")) {
            // get only the employee's reimbursements
            return this.reimbursementRepository.findAllBySubmitterUsername(payload.getUsername());
        } else if (payload.getRole().equals("finance_manager")) {
            // get all reimbursements
            return this.reimbursementRepository.findAll();
        } else {
            throw new UnauthorizedException("Access Denied: role must be 'employee' or 'finance_manager'");
        }
    }

    @Transactional // Ensures that when the method successfully returns with no exception thrown,
    // the database transaction will be committed
    public void resolveReimbursement(int id, String status, UserPayload payload) throws UnauthorizedException, InvalidParameterException, NotFoundException {
        if (!payload.getRole().equals("finance_manager")) {
            throw new UnauthorizedException("Access Denied: role must be 'finance_manager'");
        }

        if (!(status.equals("denied") || status.equals("approved"))) {
            throw new InvalidParameterException("Status can only be resolved to either denied or approved");
        }

        Optional<Reimbursement> reimbursementOpt = this.reimbursementRepository.findById(id);

        if (!reimbursementOpt.isPresent()) {
            throw new NotFoundException("Reimbursement with id " + id + " not found");
        }

        Reimbursement reimbursement = reimbursementOpt.get();

        if (!reimbursement.getStatus().equals("pending")) {
            throw new InvalidParameterException("Can only resolve 'pending' reimbursements");
        }

        // This will go and update with the database
        // (assuming you have committed the transaction)
        reimbursement.setStatus(status);
        User reviewer = userRepository.findById(payload.getUsername()).get();
        reimbursement.setReviewer(reviewer);
    }

}
