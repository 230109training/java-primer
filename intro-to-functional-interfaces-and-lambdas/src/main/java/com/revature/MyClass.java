package com.revature;

public class MyClass implements MyFunctionalInterface {

    @Override
    public boolean test(String s) {
        return s.length() > 5;
    }

}
