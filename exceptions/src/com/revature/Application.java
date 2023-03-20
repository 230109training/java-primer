package com.revature;

import com.revature.exception.DenominatorIsZeroException;

public class Application {

    public static void main(String[] args) {
        try {
            divideNumbers(10, 0);
        } catch (DenominatorIsZeroException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("hello");
    }

    // the "throws" keyword is there to tell the method that is calling this particular method
    // that this method has the potential to throw the "DenominatorIsZeroException", and therefore
    // needs to be handled by the method that called this method (divideNumbers)
    public static void divideNumbers(int x, int y) throws DenominatorIsZeroException {
        if (y == 0) {
            // The process of throwing an exception
            // interrupts the top-down execution of our code
            // Either our program will immediately crash if the exception
            // is not being handled,
            // or we will skip to the code in the catch block for
            // the exception being thrown
            throw new DenominatorIsZeroException("Denominator cannot be 0");
        }

        System.out.println(x / y);
    }

}
