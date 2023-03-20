package com.revature.collection_interfaces;

import java.util.Iterator;

public class CollectionInterfaces {

    /*
        Iterable Interface

        This is the root interface of the collection framework. All itnerfaces and classes of the Collection Framework inherits from this interface
        The main functionality of the Iterable itnerface is providing an iterator for it
        The interface has only one abstract method which is the iterator

        The iterator is used to iterate (step through one by one in order) over a collection, whihc is implemented differently based on the
        data structure
     */

    /*
        Collection Interface

        This extends the Iterable interface, containing all the basic methods which every collection has.
        These consist of adding elements, removing elements, clearing the DS, etc.
        This interface acts as the foundation for the framework as every class proceeding it inherits the methods it has in its interface

     */

    /*

        List Interface

        The main use of the List interface is working with list type data structures.
        These are structures that maintain their order (order of insertion) and allow duplicate elements to be present.
        The classes that implement the List interface in Collections are:
        - ArrayList
        - LinkedList
        - Vector

     */

    /*

        Queue Interface

        As the name suggests, this data structure acts similar to a real life queue where the first element to enter it is the first
        one to exit (FIFO).
        The order of the elements as they are inserted into the collection is important. The classes that implement the queue are
        - PriorityQueue
        - ArrayDeque
     */

    /*
        Dequeue interface

        The Deque interface is slightly different to the Queue interface. Deque stands for double-ended queue where instead of only dealing
        with the head of the queue (front), the Dequeue allows you to add or remove elements from both ends.
     */

    /*
        Set Interface

        A Set is used for an unordered group of objects but there can be no duplication stored within.
        This is used when you cannot have any duplicates in your collection as only unique elements can be stored inside this collection.
        The classes that implement this interface are:
        - HashSet
        - TreeSet
     */

    /*
        SortedSet interface

        A set that is similar to the Set interface, except that it implements extra methods that maintain the ordering of the elements
        Most collections have some way to organize themselves, a natural order that the size of a particular value is organized by largest to
        smallest or vice versa.
        - TreeSet
     */

    /*
        Map Interface

        The Map interface works with Key-Value pairs. Unlike the other Collections, the Map interfaces do not implement Iterable nor Collection
        so they require a different set of base methods.
        Key-Value pairing is useful for lookup tables, by assigning the element you are storing a unique key, it can quickly find which element you
        are searching for through a simple key instead of the object itself.
        This is useful for when objects we are storing naturally form a key-value pair like usernames & passwords, or SSN & human identities.
        The map interface is implemented by:
        - HashMap
        - TreeMap
     */

    public static void main(String[] args) {

    }
}
