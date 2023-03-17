package com.revature.model;

public class Dog extends Pet {

    public Dog(String name, int age, String favoriteFood) {
        super(name, age, favoriteFood);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.name + ": Bark!");
    }
}
