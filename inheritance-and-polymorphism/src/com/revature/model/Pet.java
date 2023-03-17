package com.revature.model;

import java.util.Objects;

public class Pet { // parent class of Pet is the "Object class"

    protected String name; // defaults to null
    protected int age; // defaults to 0
    protected String favoriteFood;

    public Pet(String name, int age, String favoriteFood) {
        super();
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public void makeNoise() {
        System.out.println("**GENERIC ANIMAL NOISES**");
    }

    // Method Overloading
    // Eat 1 unit of favorite Food
    public void eat() {
        System.out.println(getName() + " ate 1 " + this.favoriteFood);
    }

    // Eat x units of favorite Food
    public void eat(int quantity) {
        System.out.println(getName() + " ate " + quantity + " " + this.favoriteFood);
    }

    // Eat 1 unit of x food
    public void eat(String food) {
        System.out.println(getName() + " ate 1 " + food);
    }

    // Eat x units of y food
    public void eat(int quantity, String food) {
        System.out.println(getName() + " ate " + quantity + " " + food);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(name, pet.name) && Objects.equals(favoriteFood, pet.favoriteFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, favoriteFood);
    }
}
