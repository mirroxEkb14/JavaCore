package Generics.ListsTask;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTask {

    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }

        for (int i = 0; i < (integers.size() / 2); i++) {
            integers.set(i, (integers.size() - i - 1));
            integers.set((integers.size() - i - 1), i);
        }

        for (Integer integer: integers) {
            System.out.print(integer + ", ");
        }
    }
}
