package Threads.ConcurrentPackage.CollectionUseExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {

    /* We use this package in multithreaded environment
       when we often iterate through the collection

       It is not advisable to use this collection when
       you add or remove elements frequently
     */

    public static void main(String[] args) {
        withoutCopyOnWrite();
        withCopyOnWrite();
    }

    public static void withoutCopyOnWrite() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 'ConcurrentModificationException' because we try
        // to change the collection while iteration(list.add())
        for (Integer item: list) {
            System.out.println("Item -> " + item);
            list.add(5);
        }

        System.out.println("List size -> " + list.size());
    }

    public static void withCopyOnWrite() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3));

        for (Integer item: list) { // list -> [1, 2, 3]
            System.out.println("Item -> " + item); // 1, 2, 3

            // while adding, a new list is created, the link to the previous list is saved,
            // so that in the 35th string the 'list' is [1, 2, 3]
            list.add(5);
        }

        System.out.println("List size -> " + list.size());
    }
}
