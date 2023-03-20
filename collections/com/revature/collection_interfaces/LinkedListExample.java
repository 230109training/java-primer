package com.revature.collection_interfaces;

import java.util.LinkedList;

/*
    A LinkedList is built differently than an Array. Where an Array is a sequence of memory addresses, a LinkedList is not based on a continuous sequence of
    memory locations.
    Each element of a LinkedList is a separate object that contains the data that it is storing, and the location of the next address in memory that contains the next
    object in sequence. This memory location does not and in most cases is not next to each other but as each element knows where the enxt elemeent is, any element can be found


    The last element is a Null in order for the Linked List to know that it has reached the end of the sequence.
    Each element in the LinkedList is referred to as a Node.

    The LInkedList data structure can be infintely long and is excellent for manipulation and is faster than an ArrayList
    It also implements the List and Queue interface, which it means it has access to both their methods.
    THe main issue with the LinkedList is that you cannot access a random element in the list, instead the LinkedList when given an index to find will have to travel
    from the first node to the needed index in order to find what the element is.
 */
public class LinkedListExample {

    public static void main(String[] args) {
        // Initialize the linked list to contain integers

        LinkedList<Integer> integerLinkedList = new LinkedList<>();


        // Add elements using a for loop
        for (int i = 0; i < 10; i ++){
            integerLinkedList.add(i);
        }

        // print out all elements
        System.out.println(integerLinkedList);

        // Remove an element from the list using an index
        integerLinkedList.remove(5);

        // Remove an element using pop, first element of the list
        integerLinkedList.pop();

        // Remove the last element of the list
        integerLinkedList.removeLast();

        // print out each element of the collection one by one
        for (int i = 0; i < integerLinkedList.size(); i ++){
            System.out.println(integerLinkedList.get(i));
        }
    }
}
