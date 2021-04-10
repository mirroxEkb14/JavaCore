package Generics.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue someQueue = new ArrayDeque();
        someQueue.add(1);
        someQueue.add(2);
        someQueue.add(3);

        /* returns the next arguments */
//        System.out.println(someQueue.poll()); // returns the first argument (null if empty)
//        System.out.println(someQueue.peek()); // returns the first argument (null if empty)

        Queue someLinkedQueue = new LinkedList();
        someLinkedQueue.add(1);
        someLinkedQueue.add(2);
        someLinkedQueue.add(3);

        Deque someDeque = new ArrayDeque();
        someDeque.add(1);
        someDeque.add(2);
        someDeque.add(3);
    }
}
