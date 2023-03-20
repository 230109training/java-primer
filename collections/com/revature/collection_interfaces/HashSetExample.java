package com.revature.collection_interfaces;

import java.util.HashSet;
import java.util.Iterator;

/*
    The HashSet implements the Set interface, which means that there is an unordered collection that cannot contain any duplicates
    The HashSet class uses the Hash Table data structure.
    There is no guarantee that the order in which the elements are inserted is maintained and null elements are all permitted
    There is a constant time performance for basic operations like add, remove, contains, and size which make it ideal for manipulation
    especially when non-duplicate values must be maintained
 */
public class HashSetExample {
    public static void main(String[] args) {
        // Initialize the HashSet
        HashSet<Integer> integerHashSet = new HashSet<>();

        // Add elements to it
        integerHashSet.add(5);
        integerHashSet.add(23);
        integerHashSet.add(2);
        integerHashSet.add(1);
        integerHashSet.add(null);

        // Print elements of hashset
        System.out.println(integerHashSet);

        // Remove elements of Hashset
        integerHashSet.remove(23);
        integerHashSet.remove(null);

        System.out.println(integerHashSet);

        // Print out each element of HashSet with iterator
        Iterator<Integer> iterator = integerHashSet.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
