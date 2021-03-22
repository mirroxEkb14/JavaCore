package Methods;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void create() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
    }

    public void addFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode deleteFirst() {
        if (head == null) return null;

        ListNode deletedValue = head;
        head = head.next;
        return deletedValue;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) return null;

        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public int length() {
        if (head == null) return 0;

        ListNode current = head;
        int total = 0;
        while (current != null) {
            total++;
            current = current.next;
        }
        return total;
    }

    public boolean find(int value) {
        if (head == null) return false;

        ListNode current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode reverse() {
        if (head == null) return null;

        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.create();
        sll.display();
        System.out.println(sll.length());

        System.out.println();

//        sll.addFirst(0);
//        sll.display();
//        System.out.println(sll.length());
//
//        System.out.println();
//
//        sll.addLast(5);
//        sll.display();
//        System.out.println(sll.length());
//
//        System.out.println();
//
//        sll.deleteFirst();
//        sll.display();
//        System.out.println(sll.length());
//
//        System.out.println();

//        sll.deleteLast();
//        sll.display();
//        System.out.println(sll.length());

//        System.out.println();
//
//        System.out.println(sll.find(4));
    }
}
