package com.revature.collection_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionAlgorithm {

    /*
    All of these are from the Collections class (Not the Collection interface) and are static methods associated with it.

    Most of them work on the List interface implementation, but some work on other Collection data structures.

    The algorithms all ahve a default way of how they interact with a collection, but a Comparator can be provided in to change how this ordering
    is implemented
     */

    // Sorting
    /*
        The sort algorithm will reorder a list in ascending order based on its natural ordering or one provided to it
     */

    public void sortingExample(){
       // ArrayList collection
       List<String> list = new ArrayList<>();

       list.add("Mike");
       list.add("Jim");
       list.add("Lucy");
       list.add("Michelle");
       list.add("Nathan");
       list.add("George");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
    }

    /*
    Shuffling

    This algorithm is used to remove any ordering the List. This is useful for instances when randomness is needed like mimicking shuffling a pack of cards
     */

    public void shufflingExample(){
        List<String> list = new ArrayList<>();

        list.add("Mike");
        list.add("Jim");
        list.add("Lucy");
        list.add("Michelle");
        list.add("Nathan");
        list.add("George");

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        CollectionAlgorithm ca = new CollectionAlgorithm();
//        ca.sortingExample();
        ca.shufflingExample();
    }


}
