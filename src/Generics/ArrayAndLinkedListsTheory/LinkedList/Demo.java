package Generics.ArrayAndLinkedListsTheory.LinkedList;

public class Demo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // add to the and of the list
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        // display ('void' method)
        linkedList.display();

        // 'toString' method returns the string of all list elements
        System.out.println("List in string format: " + linkedList.toString());

        // returns the size of the list
        System.out.println("List size -> " + linkedList.size());

        // does the same as 'size()' method
        System.out.println("List length -> " + linkedList.length());

        // inserts a value at the beginning of the list
        linkedList.insertAtFirst(0);
        System.out.println("Inserted in the beginning: " + linkedList.toString());

        // take an elements by index
        System.out.println("Element at 1 index: " + linkedList.findValue(1));

        // take an index by value
        System.out.println("Index of '3' value: " + linkedList.findIndex(3));

        // insert a value at given index
        linkedList.insertAt(1, 100);
        System.out.printf("List after 'insertAt': %s,\n", linkedList.toString());
        System.out.println("Element at 1 index: " + linkedList.findValue(1));
    }
}
