package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.List;

/**
 * Метод reduce позволяет выполнять агрегатные функции на всей коллекцией
 * (такие как сумма, нахождение минимального или максимального значение и т.п.),
 * он возвращает одно значение для стрима, функция получает два аргумента —
 * значение полученное на прошлых шагах и текущее значение.
 *
 * Дана коллекция чисел Arrays.asList(1, 2, 3, 4, 2)
 * выполним над ними несколько действий используя reduce.
 */

public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(
                1, 2, 3, 4, 2
        );

//        System.out.println(task1(integers));
//        System.out.println(task2(integers));
        System.out.println(task3(integers));
    }

    /**
     * Получить сумму чисел или вернуть 0
     */
    public static long task1(List<Integer> integers) {
        return integers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    /**
     * Вернуть максимум или -1
     */
    public static long task2(List<Integer> integers) {
        return integers.stream()
                .reduce(Math::max)
                .orElse(-1);
    }

    /**
     * Вернуть сумму нечетных чисел или 0
     */
    public static long task3(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 != 0)
                .reduce(Integer::sum)
                .orElse(0);
    }
}

