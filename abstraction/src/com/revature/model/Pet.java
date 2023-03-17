package com.revature.model;

public abstract class Pet {

    protected String name;
    protected int age;
    protected String favoriteFood;

    public Pet(String name, int age, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public abstract void makeNoise();

    public void eat() {
        System.out.println(this.name + " ate 1 " + this.favoriteFood);
    }

}
