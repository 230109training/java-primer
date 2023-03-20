package com.revature.old_data_structures;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

public class CoreCollection {

    /*
        Collection API is a framework

        Frameworks: Ready made architectures, that represent a set of classes and interfaces

        Collection Framework itself represents a unified architecture for storing and manipulating a group of objects

        - Interfaces and their implementations
        - Algorithms


     */

    public void needForCollectionAPI(){
        // An array
        int arr[] = new int[] {1, 2, 3, 4};

        Vector<Integer> vector = new Vector<>();
        Hashtable<Integer, String> hashTable = new Hashtable<>();

        // Adding an element
        // You can't with an array

        vector.addElement(1);
        vector.addElement(2);

        hashTable.put(1, "A");
        hashTable.put(2, "B");

        // Instantiating the DS are different
        // Arrays uses []
        // Vectors and Hashtables require {}

        // Element insertion, accessing, algorithms, all have to be different

        System.out.println(arr[0]);
        System.out.println(vector.elementAt(0));
        System.out.println(hashTable.get(1));


    }

    /*
    None of these collections implement a standard member access interface, making it difficult to write algorithms that can work
    for mulitple different types of collections.
    The vector methods are also final, you cannot extend or override the class methods
    Java devs came up with the common Collection interface to deal with this issue

    Advantages
        1. Consistent API, we have the absic interface like COllection, Set, List, Map
            If a class (ArrayList, LinkedList) implements these then they have a common set of methods

        2. Reduced programming effort, the focus is not on the DS itself and how it is designed, it's based on what is best
           for the system as a whole

        3. Increase program speed and quality, performance is improved by using high-performance implementations of useful data
           structures and algorithms
     */
}
