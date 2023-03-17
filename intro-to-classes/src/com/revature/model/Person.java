package com.revature.model;

public class Person {

    // Fields are variables declared at the class level
    // 1. static fields
    // 2. instance fields
    public static int numberOfCreatedObjects = 0;

    // If no value is provided to a field, it will have a default value
    // reference types -> null
    // numerical types -> 0 or 0.0
    // boolean -> false
    // Fields / properties
    public String firstName; // null
    public String lastName; // null
    public int age; // 0

    // If and only if you do not define your own constructor in the class,
    // Java gives you a default no-args constructor
    // public Person() { }

    // Constructor
    // 2 different constructors:
    // 1. no-args constructor
    // 2. all-args constructor
    public Person() {
        Person.numberOfCreatedObjects++; // Person.<static variable>
    }

    public Person(String firstName, String lastName, int age) {
        Person.numberOfCreatedObjects++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hi, my name is " + this.firstName + " " + this.lastName);
    }

    public void haveBirthday() {
        this.age++;
    }

    public static void printNumberOfCreatedObjects() {
        System.out.println("The total number of Person objects created is " + Person.numberOfCreatedObjects);
    }
}
