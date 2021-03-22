package JavaCollections.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CodeDesignArrays {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // we can pass any List to this method because of 'List<Integer> list'
        processAnyList(arrayList);
        processAnyList(linkedList);

        // only ArrayList because of 'ArrayList<Integer> arraylist'
        processArrayList(arrayList);
    }

    public static void processAnyList(List<Integer> list) {
        if (list instanceof LinkedList) { // if we need LinkedList
            // code
        } else if (list instanceof ArrayList) { // if we need ArrayList
            // code
        }
    }

    public static void processArrayList(ArrayList<Integer> arrayList) {
    }
}
