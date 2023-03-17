package com.revature.model;

public class Dog extends Pet {

    public Dog(String name, int age, String favoriteFood) {
        super(name, age, favoriteFood); // Calls the Pet(String, int, String) constructor
    }

    // Method overriding
    @Override
    public void makeNoise() {
        System.out.println(super.name + ": Bark!");
    }

    public void playFetch() {
        System.out.println(super.name + " is playing fetch!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }


}
