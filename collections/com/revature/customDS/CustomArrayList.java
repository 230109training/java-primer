package com.revature.customDS;

public class CustomArrayList {

    // What can you do with this Array
    // Add elements
    // Remove Elements
    // Get elements

    public Integer[] array;

    public CustomArrayList(Integer[] array){
        this.array = array;
    }

    public void add(int num){
       // check to see if array is at max length
       // if it is at max length, create a new array with double the size and copy the old elements to it
       // Then continue to add the new element
        array[array.length - 1] = num;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 2, 3, 4};
        CustomArrayList customArray = new CustomArrayList(array);

        customArray.remove();
        customArray.get();
    }

    private Integer get() {
        return 0;
    }

    private void remove() {
    }
}
