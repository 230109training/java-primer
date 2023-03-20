package com.revature.collection_interfaces;

import java.util.ArrayList;

/*
ArrayList provides Java with a dynamic Array. Previously we have seen Arrays as fixed in size and only working with primitive data types (and String).
An ArrayList can not work with primitive data types, instead a Wrapper class must be used.
Wrapper classes are used to store values of primitives to allow them to be interacted with like objects.
The ArrayList can also grow and shrink in size as needed automatically, and allows us to access any element within the list (random access).

While the ArrayList is slower than the standard Array, its benefits in manipulation makes it helpful in a number of programs
 */
public class ArrayListExample {
    public static void main(String[] args) {

        // Initialize an ArrayLIst with the data type of Integer

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        // Populate the ArrayList with a for loop
        for (int i = 0; i < 10; i ++){
            integerArrayList.add(i);
        }

        // Print out the elements of the ArrayList
        System.out.println(integerArrayList);

        // Remove element at index 5
        integerArrayList.remove(5);

        // Print out each element of the ArrayList with a for loop
        for(int i = 0; i < integerArrayList.size(); i++){
            System.out.println(integerArrayList.get(i));
        }
    }
}
