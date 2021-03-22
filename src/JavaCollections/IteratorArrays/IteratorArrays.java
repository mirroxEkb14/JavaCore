package JavaCollections.IteratorArrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorArrays {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        /*  task: we have ArrayList and we want to remove all the even digits in this array;

            Java forbids us to remove elements from array in a loop:
            for (int number: arrayList) {
                arrayList.remove(number);
            }
            -> ConcurrentModificationException

            because of this we use Iterator */

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
//        arrayList.forEach(System.out::println);

        List<Integer> example = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            example.add(i);
        }
        int temp;
        for (int j = 0; j < example.size() / 2; j++) {
            temp = example.get(j);
            example.set(j, example.size() - j);
            example.set(example.size() - j - 1, temp);
        }
        System.out.println(example);



    }
}
