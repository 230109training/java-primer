package com.example.employeereimbursementsystemsb.daos;

import com.example.employeereimbursementsystemsb.models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {

    // JPQL, not SQL
    @Query("SELECT r FROM Reimbursement r JOIN r.submitter u WHERE u.username = :username")
    public abstract List<Reimbursement> findAllBySubmitterUsername(String username);

}
