package Generics.ArrayAndLinkedListsTheory.LinkedList;

public class LinkedList<E> {
    private Node<E> head; // the first node: [head, ...]
    private int size; // the size of the list

    private static class Node<E> {
        E data; // the data that the node contains
        Node<E> next; // reference to the next node
    }

    public void insert(E e) {

        /* create a node like 'head', where we have
        data and do not have reference to the next node */
        Node<E> newNode = new Node<>();
        newNode.data = e;
        newNode.next = null;

        if (head == null) head = newNode; // if the list is empty

        /* here we need to take the last node, then override the
           'next' field, having given a reference to a new node(like 'head')*/
        else {
            Node<E> tempNode = head; // take 'head'
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

    @Override
    public String toString() {
        if (head == null) return "null";

        StringBuilder result = new StringBuilder("[");
        Node<E> cur = head;

        while (cur != null) {
            result.append(cur.data).append(", ");
            cur = cur.next;
        }
        return result.substring(0, result.length() - 2) + "]";
    }

    public int size() {
        return size;
    }

    // image there is no such field 'size'
    public int length() {
        Node<E> cur = head;
        int counter = 0;

        while (cur != null) {
            counter++;
            cur = cur.next;
        }
        return counter;
    }

    public void insertAtFirst(E e) {
        /* create a new node with passed element,
           make this node a 'head', in turn,
           'head' node assign to 'next' field of a new node */
        Node<E> newNode = new Node<>();
        newNode.data = e;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E findValue(int index) {
        if (index >= length()) throw new IndexOutOfBoundsException();

        Node<E> cur = head;
        int counter = 0;

        while (counter != index) {
            cur = cur.next;
            counter++;
        }
        return cur.data;
    }

    public int findIndex(E value) {
        if (head == null) return -1;

        Node<E> cur = head;
        int counter = 0;
        while (cur != null) {
            if (cur.data == value) return counter;
            cur = cur.next;
            counter++;
        }
        return -1;
    }

    public void insertAt(int index, E e) {
        if (index >= length()) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            insertAtFirst(e);
            return;
        }

        // create a new node with passed data
        Node<E> newNode = new Node<>();
        newNode.data = e;
        newNode.next = null;

        // find the necessary node
        Node<E> tempNode = head;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    public void reverse() {
        if (head == null) throw new IllegalStateException("The list is empty");

        Node<E> prev = null;
        Node<E> cur = head;
        Node<E> next;

//        while ()
    }
}
