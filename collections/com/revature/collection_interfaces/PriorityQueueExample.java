package com.revature.collection_interfaces;

import java.util.PriorityQueue;

/*
The PriorityQueue works like a queue using the FIFO principle. However, it also has the ability to process other objects inside the collection based on priority.
The elements in the PriorityQueue are ordered based on their natural order, or you can provide your own custom ordering using a Comparator.


 */
public class PriorityQueueExample {

    public static void main(String[] args) {

        // Initialize a prioritiy queue
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

        // Adding items to the queue
        integerPriorityQueue.add(100);
        integerPriorityQueue.add(40);
        integerPriorityQueue.add(15);

        // print out the elements of the queue
        System.out.println(integerPriorityQueue);

        // Print the top element of the queue
        System.out.println(integerPriorityQueue.peek());

        // print top element and then remove it
        System.out.println(integerPriorityQueue.poll());

        // print top element again
        System.out.println(integerPriorityQueue.peek());
    }
}
