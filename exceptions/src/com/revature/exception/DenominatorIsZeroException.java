package com.revature.exception;

// Whenever we create a custom exception, we should either extend
// 1. The RuntimeException class
//      -> Anytime we extend the RuntimeException class, we are creating
//         an "unchecked exception"
//      "unchecked exception": an exception that the compiler DOES NOT enforce the need to be handled
// 2. The Exception class
//      -> Anytime we extend the Exception class, we are creating a
//         "checked exception"
//      "checked exception": an exception that the compiler ENFORCES needs to be handled
public class DenominatorIsZeroException extends Exception {

    public DenominatorIsZeroException(String message) {
        super(message);
    }

}
