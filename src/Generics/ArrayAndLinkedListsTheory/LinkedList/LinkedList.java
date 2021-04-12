package Generics.ArrayAndLinkedListsTheory.LinkedList;

public class LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> next;
    }

    public void insert(E e) {
        Node<E> newNode = new Node<>();
        newNode.data = e;
        newNode.next = null;

        if (head == null) head = newNode;
        else {
            Node<E> tempNode = head;
            while (tempNode.next != null)
                tempNode = tempNode.next;

            tempNode.next = newNode;
        }
        size++;
    }

    public void display() {
        Node<E> cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
