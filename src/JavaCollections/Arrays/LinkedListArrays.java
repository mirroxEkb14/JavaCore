package JavaCollections.Arrays;

import java.util.LinkedList;
import java.util.List;

public class LinkedListArrays {
    public static void main(String[] args) {
        /* If we often remove elements in the middle or in the beginning;
           All the elements have a link to the next element */

        List<String> linkedList = new LinkedList<>();
        linkedList.add("one"); // just add
        linkedList.add("two");
        linkedList.add("three");

        /* we have a list: ["one" -> "two" -> "three"], we want to remove "two" element;
            how many operations will it take?
            1. we go to element "one"
            2. we go to element "two", remove it and link it to the next element (in our case - "three")
                now we have ["one" -> "three"] */

        linkedList.remove("two");


        LinkedList<String> example = new LinkedList<>();
        example.addFirst("0"); // add in the beginning
        example.addLast("4"); // add in the end


    }
}
