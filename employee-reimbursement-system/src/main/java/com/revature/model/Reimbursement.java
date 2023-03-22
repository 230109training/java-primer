package com.revature.model;

import java.util.Objects;

public class Reimbursement {

    private int id;
    private String description;
    private String submitter;
    private String status;

    public Reimbursement() {
    }

    public Reimbursement(int id, String description, String submitter, String status) {
        this.id = id;
        this.description = description;
        this.submitter = submitter;
        this.status = status;
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

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(submitter, that.submitter) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, submitter, status);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", submitter='" + submitter + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
