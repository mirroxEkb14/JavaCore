package Generics.ArrayAndLinkedListsTheory.LinkedList;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addLast("str1");
        linkedList.addLast("str2");
        linkedList.addLast("str3");

        linkedList.display();
    }
}
