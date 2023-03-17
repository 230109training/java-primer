package com.revature;

import com.revature.model.Person;

public class Application {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.firstName); // null
        System.out.println(p.lastName); // null
        System.out.println(p.age); // 0

        p.firstName = "Bach";
        p.lastName = "Tran";
        p.age = 25;

        System.out.println(p.firstName); // Bach
        System.out.println(p.lastName); // Tran
        System.out.println(p.age); // 25

        p.greet(); // Hi, my name is Bach Tran

        Person p2 = new Person("John", "Doe", 30);

        System.out.println(p2.firstName); // John
        System.out.println(p2.lastName); // Doe
        System.out.println(p2.age); // 30

        p2.greet(); // Hi, my name is John Doe
        p2.haveBirthday(); // increase age by 1 (30 to 31)
        System.out.println(p2.age); // 31

        p.haveBirthday(); // increase age by 1 (25 to 26)
        System.out.println(p.age); // 26

        System.out.println(Person.numberOfCreatedObjects); // 2

        Person.printNumberOfCreatedObjects();
    }

}
