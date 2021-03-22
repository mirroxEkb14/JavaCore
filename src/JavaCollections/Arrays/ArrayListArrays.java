package JavaCollections.Arrays;

import java.util.*;

public class ArrayListArrays {
    public static void main(String[] args) {
        /*  A regular array (it has a fixed size), it has an array inside, when it ends, creates a new array,
            copies all data from the old to the new one and extends;

            All the elements are in order, so we can go through the list */

        List<Integer> arrayList = new ArrayList<>(); // ArrayList<>(size of the array)
        // ArrayList<Integer> example = new ArrayList<>();

        arrayList.add(1); // just add
        arrayList.get(0); // get by index
        arrayList.contains(1); // true/false
        arrayList.remove(0); // remove by index (ineffective if the deletion occurs in the middle or in the beginning)
        arrayList.size(); // list`s size
        arrayList.forEach(System.out::println); // print

        // if we need to carry out many deletions
        arrayList = new LinkedList<>();


        Queue<String> linkedQueue = new LinkedList<>();
        linkedQueue.add("Smith");
        linkedQueue.add("Mary");

        List<String> arrayListTwo = new ArrayList<>(linkedQueue);
        System.out.println(arrayListTwo); // [Smith, Mary]


        // how deletion goes in ArrayList
        List<String> exampleArray = new ArrayList<>();
        exampleArray.add("one");
        exampleArray.add("two");
        exampleArray.add("three");

        /* we have a list: ["one", "two", "three"], we want to remove "two" element;
            how many operations will it take?
            1. we go to element "one"
            2. we go to element "two" and remove it
            3. we move all the next elements by one (in our case we move "three" element by one back)
            total: three operations (list size)

            *remove by index is faster */

        exampleArray.remove("two");
    }
}
