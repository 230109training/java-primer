package com.revature;

import com.revature.model.Cat;
import com.revature.model.Dog;
import com.revature.model.Pet;

public class Application {

    public static void main(String[] args) {
        Dog d = new Dog("Fido", 3, "Steak");
        System.out.println(d.getName());
        System.out.println(d.getAge());

        Cat c = new Cat("Mittens", 2, "Fish");
        System.out.println(c.getName());
        System.out.println(c.getAge());

        d.playFetch();
        c.playWithYarn();

        d.eat(); // Fido ate 1 Steak
        c.eat(); // Mittens ate 1 Fish

        d.eat(2); // Fido ate 2 Steak
        c.eat(5); // Mittens ate 5 Fish

        d.eat("Kibbles");
        c.eat("Fancy Feast");

        d.eat(20, "Kibbles");
        c.eat(2, "Fancy Feast");

        d.makeNoise();
        c.makeNoise();

        // You can use a Parent class datatype to refer to a child class object
        Object o = new Dog("Sparky", 5, "Chicken");
        // Even though o is referring to a Dog object,
        // the o variable has no knowledge of the playFetch() method because
        // the o variable is "Object" type
        ((Dog) o).playFetch();

        // Downcasting to Pet or Dog both work, because Pet defines the eat() method
        // and Dog of course inherits from the Pet class
        ((Pet) o).eat();
        ((Dog) o).eat();

        Pet p = (Pet) o; // Downcasting
        ((Dog) p).playFetch();

        Dog d2 = (Dog) p; // Downcasting
        d2.playFetch();

        // Method overriding is also known as "runtime polymorphism" because we swap out different types of objects
        // for a particular reference variable, call a method, and it will know to use the correct overridden method
        // for that particular object
        Pet pet = new Dog("Fido", 10, "testing");
        // Overridden makeNoise in Dog
        pet.makeNoise(); // Fido: Bark!

        pet = new Cat("Whiskers", 6, "testing");
        // Overridden makeNoise in Cat
        pet.makeNoise(); // Whiskers: Meow!

        // toString
        System.out.println(d2);
        System.out.println(d);


        Dog d3 = new Dog("Fido", 2, "Steak");
        Dog d4 = new Dog("Fido", 2, "Steak");

        System.out.println(d3 == d4); // false
        // when using == to compare reference variables
        // -> true when both reference variables are pointing to the same object in memory
        // -> false if the two reference variables are pointing to different objects
        // The same is true with the equals method (IF AND ONLY IF IT HAS NOT BEEN OVERRIDDEN)

        System.out.println(d3.equals(d4)); // true, because even though d3 and d4 are different objects
        // Those two objects have the same name attribute, the same age attribute, and the same favoriteFood attribute

        // When we override equals, we need to override hashCode as well, since we need to satisfy the following
        // contract:
        // 1. If two objects are equal, they must have the same hashCode
        // 2. If two objects have the same hashCode, they don't necessarily need to be equal (hash collision)

        // d3 and d4 are equal to each other
        // therefore they must have the same hashCode
        System.out.println(d3.hashCode());
        System.out.println(d4.hashCode());
    }

}
