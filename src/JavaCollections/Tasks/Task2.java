package JavaCollections.Tasks;

import java.util.HashSet;
import java.util.List;

/**
 * Написать метод countUnique, который принимает
 * целочисленный список и возвращает кол-во
 * уникальных целых чисел в этом списке
 * Пример:
 * [1, 2, 3, 1, 4, 5, 7, 7] -> 6
 */

public class Task2 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 1, 4, 5, 7, 7);
        System.out.println(countUnique(list));
    }

    public static int countUnique(List<Integer> list) {
        return new HashSet<Integer>(list).size();
    }
}
