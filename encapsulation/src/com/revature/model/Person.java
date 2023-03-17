package com.revature.model;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        // Create some logic that checks if all characters in the firstName
        // are alphabetical or an apostrophe
        if (firstName.matches("[a-zA-Z']+")) {
            this.firstName = firstName;
        } else {
            System.out.println("First name can only be set to alphabetical characters or apostrophes");
        }

    }
}
