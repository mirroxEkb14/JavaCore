package JavaCollections.Tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Написать метод, котоырй принимает целочисленный
 * список и возвращает целочисленный список только
 * с нечетными значениями
 */

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(removeEven(list));
    }

    public static List<Integer> removeEven(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer value: list) {
            if (value % 2 != 0) {
                result.add(value);
            }
        }
        return result;
    }
}
