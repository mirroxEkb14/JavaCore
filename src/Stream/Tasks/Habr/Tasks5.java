package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * даны две коллекции collection1 = Arrays.asList(«a1», «a2», «a3», «a1») и
 * collection2 = Arrays.asList(«1,2,0», «4,5»), давайте посмотрим как её
 * можно обрабатывать используя различные map функции
 */

public class Tasks5 {

    public static void main(String[] args) {
        List<String> collection1 = Arrays.asList(
                "a1", "a2", "a3", "a1"
        );

        List<String> collection2 = Arrays.asList(
                "1, 2, 0", "4, 5"
        );

//        System.out.println(task1(collection1));
//        System.out.println(Arrays.toString(task2(collection1)));
//        System.out.println(Arrays.toString(task3(collection2)));
        System.out.println(task4(collection2));
    }

    /**
     * Добавить "_1" к каждому элементу первой коллекции
     */
    public static List<String> task1(List<String> strings) {
        return strings.stream()
                .map(s -> s + "_1")
                .collect(Collectors.toList());
    }

    /**
     * В первой коллекции убрать первый символ и вернуть массив чисел (int[])
     */
    public static int[] task2(List<String> strings) {
        return strings.stream()
                .mapToInt(s -> Integer.parseInt(s.substring(1)))
                .toArray();
    }

    /**
     * Из второй коллекции получить все числа,
     * перечисленные через запятую из всех элементов
     */
    public static String[] task3(List<String> strings) {
        return strings.stream()
                .flatMap(p -> Arrays.asList(
                        p.split(",")).stream())
                .toArray(String[]::new);
    }

    /**
     * Из второй коллекции получить сумму всех чисел,
     * перечисленных через запятую
     */
    public static long task4(List<String> strings) {
        return strings.stream()
                .map(s -> s.replaceAll(" ", ""))
                .flatMapToInt(p -> Arrays.asList(
                        p.split(",")).stream().mapToInt(Integer::parseInt))
                .sum();
    }
}
