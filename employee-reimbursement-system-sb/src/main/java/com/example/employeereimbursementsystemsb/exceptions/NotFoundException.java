package com.example.employeereimbursementsystemsb.exceptions;

import org.hibernate.annotations.NotFound;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

}
