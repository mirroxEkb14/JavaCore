package JavaCollections.QueueGenerics;

import java.util.*;

public class QueueCollect {
    // stack - LIFO; queue - FIFO

    public static void main(String[] args) {

    }

    public static void commands() {
        Queue<String> queueLinked = new LinkedList(); // unsorted
        Queue<Integer> queuePriority = new PriorityQueue(); // sorted

        queueLinked.offer("1"); // just add
        queueLinked.offer("2"); // just add
        queueLinked.peek(); // select without removal
        queueLinked.poll(); // select with removal
        while (queueLinked.size() > 0) { // print the queue
            System.out.println(queueLinked.poll());
        }

        queuePriority.add(2);
        queuePriority.add(1);
        while (queuePriority.size() > 0) {
            System.out.println(queuePriority.poll());
        }
    }
}
