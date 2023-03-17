package com.revature;

import com.revature.model.Person;

public class Application {

    public static void main(String[] args) {
        Person p = new Person("Bach", "Tran", 25);

        // Does not work, since firstName is private
//        System.out.println(p.firstName);
//        p.firstName = "changed name";

        System.out.println(p.getFirstName());
        p.setFirstName("O'Neil");

        // No arbitrary bypassing of the rules is allowed!
        // p.firstName = "123124";

        System.out.println(p.getFirstName());
    }

}
