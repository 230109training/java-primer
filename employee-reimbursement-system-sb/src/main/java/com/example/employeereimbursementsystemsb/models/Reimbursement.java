package com.example.employeereimbursementsystemsb.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double amount;

    @Column
    private String description;

    @Column
    private String status;

    // This forms a many to one relationship with the "User" entity
    // The "User" entity below specifies who submitted the reimbursement
    @ManyToOne
    private User submitter; // Many reimbursements can be submitted by one employee user

    // The "user" entity below specifies who approved or denied the reimbursement
    @ManyToOne
    private User reviewer; // Many reimbursements can be approved/denied by one finance manager user

    public Reimbursement() {
    }

    public Reimbursement(int id, double amount, String description, String status, User submitter, User reviewer) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.submitter = submitter;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", submitter=" + submitter +
                ", reviewer=" + reviewer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(description, that.description) && Objects.equals(status, that.status) && Objects.equals(submitter, that.submitter) && Objects.equals(reviewer, that.reviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, status, submitter, reviewer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

}
