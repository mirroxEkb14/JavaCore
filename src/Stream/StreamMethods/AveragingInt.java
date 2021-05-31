package Stream.StreamMethods;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AveragingInt {

    /**
     * Такой коллектор позволяет посчитать среднее арифметическое
     * значение чисел (есть методы также для double, long, int).
     *
     * @param args
     */

    public static void main(String[] args) {

        // "lions" -> 5, "tigers" -> 6, "bears" -> 5
        // 5 + 6 + 5 = 16
        // 16 / 3 = 5.33333...
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length)); // 5.33333333333333333
    }
}
