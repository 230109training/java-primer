package com.revature.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-incrementing integer
    private int id;

    @Column
    private String description;

    @Column
    private double amount;

    @Column
    private String status;

    @ManyToOne // We associate the User entity with the reimbursement object
    // We use Many to one, since Reimbursements (many) to Users (one) is Many to one
    private User submitter;

    public Reimbursement() {
    }

    public Reimbursement(int id, String description, double amount, String status, User submitter) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.submitter = submitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(description, that.description) && Objects.equals(status, that.status) && Objects.equals(submitter, that.submitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, status, submitter);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", submitter=" + submitter +
                '}';
    }
}
