package JavaTasks.Itnanru.Generics;

public class LinkedList<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public LinkedList() {
        fstNode = new Node<E>(null, null, lstNode);
        lstNode = new Node<E>(null, fstNode, null);
    }

    private class Node<E> {
        private E cur;
        private Node<E> prev;
        private Node<E> next;

        private Node(E cur, Node<E> prev, Node<E> next) {
            this.cur = cur;
            this.prev = prev;
            this.next = next;
        }
    }

    // Node(3)
    // [0, 1, 2]

    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.cur = e;
        lstNode = new Node<E>(null, prev, null);
        prev.next = lstNode;
        size++;
    }
}
