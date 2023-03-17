package com.revature.model;

public class Cat extends Pet {

    public Cat(String name, int age, String favoriteFood) {
        super(name, age, favoriteFood); // Calls the Pet(String, int) constructor
    }

    // Method overriding
    @Override
    public void makeNoise() {
        System.out.println(getName() + ": Meow!");
    }

    public void playWithYarn() {
        System.out.println(getName() + " is playing with yarn!");
    }

}
