package Stream.Tasks.SkillFactory;

import java.util.stream.IntStream;

/**
 * Сгенерируйте последовательность чисел от 1 до 100 включительно,
 * ограничьте ее последними 50 числами, оставьте только те числа,
 * которые делятся без остатка на 2 или на 5, и посчитайте сумму
 * полученных чисел. В ответе у вас должно выйти 2275.
 */

public class Task4 {

    public static void main(String[] args) {
        Integer intStream = IntStream.rangeClosed(1, 100)
                .filter(integer -> integer >= 51)
                .filter(integer -> integer % 2 == 0 || integer % 5 == 0)
                .sum();

        System.out.println(intStream);
    }
}
