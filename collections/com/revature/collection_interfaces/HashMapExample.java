package com.revature.collection_interfaces;

import java.util.HashMap;
import java.util.Map;

/*
The HashMap collection implements the Map interface. The Map interface is not related to the Collection interface, and as such, it has its own
behaviors unique to it.
The HashMap uses the key-value pair data-structure. This means that each element (value) is associated with a key.
This is similar to the other data structures, like an Array where an array uses indexes (keys) to locate the elements within it (values).

With a HashMap we can create the keys using any object data type, including null. The only requirement is that they be unique.
You can have duplicate values, not keys.
The HashMap itself uses hashing for indexing, this is essentially converting a larger value to a smaller value that still represents the larger one.
This allows faster search and indexing operations

 */
public class HashMapExample {
    public static void main(String[] args) {
        // Initialize a HashMap with a datatype for the key and value pair
        // THe order is <key, value>
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Add values into the HashMap, we use put() not add()
        hashMap.put(1, "Mike");
        hashMap.put(2, "Jim");
        hashMap.put(3, "Nigel");
        hashMap.put(null, "empty");


        // Print out key value pairs
        System.out.println(hashMap);

        // We can retrieve elements using their key
        System.out.printf("The value for %d is %s \n", 3, hashMap.get(3));

        // Iterating over the HashMap uses an Entry Set
        // This is unordered as Maps do not maintain insertion order
        for (Map.Entry<Integer, String> e: hashMap.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
