package com.revature;

// Fully Qualified Class Name (FQCN)
// <package name>.<class name>
import com.revature.model.Person;

public class Application {

    public static void main(String[] args) {
        // primitive datatypes
        byte b = -10; // 128 to 127
        short s = 1000; // -32768 to 32767
        char c = 'z';
        int i = 343444343; // -2,147,483,648 to  2,147,483,647
        long l = 34234234809384083L;
        float f = 3.14F;
        double d = 3.14;
        boolean bool = false;
        // all of the above are PRIMITIVE variables

        // Note: String are objects, not primitives
        String greeting = "Hello"; // REFERENCE variable
        Person p = new Person("Bach", "Tran", 25);
        Person p2 = p;
        p2.firstName = "changed name";
        System.out.println(p.firstName); // changed name

        Person p3 = null; // null indicates the absence of an object. We
        // do not have an object associated with this variable
    }

}
