package JavaCollections.QueueGenerics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeCollect {

    public static void main(String[] args) {
        Deque<String> dequeLinked = new LinkedList<>(); // extends 'Queue', plus some new methods (old), better in removing

        Deque<String> dequeArray = new ArrayDeque<>(); // faster than linkedList (is used), better in addition elems

    }
}
