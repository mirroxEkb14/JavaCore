package Generics.ArrayAndLinkedListsTheory.LinkedList;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
        first = new Node(null, null, last);
        last = new Node(null, first, null);
    }

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        private Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /* LinkedList -> ["str1", "str2", "str3"]

     * "str1" -> new Node(item = "str1",  "str2" -> new Node(item = "str2",  "str3" -> new Node(item = "str3",
                          prev = null,                       prev = "str1",                     prev = "str2",
                          next = "str2"),                    next = "str3"),                    next = null)

     *  Node<E> f = "str1" = Node(item = "str1",
                                  prev = null,
                                  next = "str2")

     *  Node<E> newNode = new Node<>(item: e, prev: null, next: f)
            newNode -> item = e
                       prev = null
                       next = f = item: "str1"
                                  prev: null
                                  next: "str2"

     *  first = newNode

     *  .addFirst("str0") -> ["str0", "str1", "str2", "str3"]
     */

    public void addLast(E e) {
        Node<E> prev = last;
        prev.item = e;
        last = new Node<>(null, prev, null);
        prev.next = last;
        size++;
    }

    public void display() {
        Node<E> cur = first;
        while (cur != null) {
            System.out.print(cur.item + " --> ");;
            cur = cur.next;
        }
        System.out.println("null");
    }
}
