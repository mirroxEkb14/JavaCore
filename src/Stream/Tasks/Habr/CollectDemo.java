package Stream.Tasks.Habr;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Если с toArray все просто, можно либо вызвать toArray() получить Object[],
 * либо toArray(T[]::new) — получив массив типа T, то collect позволяет много
 * возможностей преобразовать значение в коллекцию, map'у или любой другой тип.
 * Для этого используются статические методы из Collectors, например преобразование в
 * List будет stream.collect(Collectors.toList()).
 *
 * Давайте рассмотрим статические методы из Collectors:
 * Метод	                                               Описание
 * toList, toCollection, toSet	                           представляют стрим в виде списка, коллекции или множества
 * toConcurrentMap, toMap	                               позволяют преобразовать стрим в map
 * averagingInt, averagingDouble, averagingLong	           возвращают среднее значение
 * summingInt, summingDouble, summingLong	               возвращает сумму
 * summarizingInt, summarizingDouble, summarizingLong	   возвращают SummaryStatistics с разными агрегатными значениями
 * partitioningBy	                                       разделяет коллекцию на две части по соответствию условию и
 *                                                          возвращает их как Map<Boolean, List>
 * groupingBy	                                           разделяет коллекцию на несколько частей и возвращает Map<N, List<T>>
 * mapping	                                               дополнительные преобразования значений для сложных Collector'ов
 */

public class CollectDemo {

    public static void main(String[] args) {

        /**
         * Дана коллекция чисел Arrays.asList(1, 2, 3, 4), рассмотрим работу collect и toArray с ней
         */
        List<Integer> integers = Arrays.asList(
                1, 2, 3, 4
        );

//        System.out.println(task1Int(integers));
//        System.out.println(task2Int(integers));
//        System.out.println(task3Int(integers));
//        System.out.println(task4Int(integers));

        /**
         * Дана коллекция строк Arrays.asList(«a1», «b2», «c3», «a1»), рассмотрим работу collect и toArray с ней
         */
        List<String> strings = Arrays.asList(
                "a1", "b2", "c3", "a1"
        );

//        System.out.println(task1Str(strings));
//        System.out.println(Arrays.toString(task2Str(strings)));
//        System.out.println(task3Str(strings));
//        System.out.println(task4Str(strings));
//        System.out.println(task5Str(strings));
        System.out.println(task6Str(strings));
    }

    /**
     * Получить сумму нечетных чисел
     */
    public static long task1Int(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.summingInt(p -> p % 2 == 0? 0: p)); // .mapToInt().sum() ; .mapToInt(p -> p % 2 == 0 ? 0 : p).sum()
    }

    /**
     * Вычесть от каждого элемента 1 и получить среднее
     */
    public static double task2Int(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.averagingInt(p -> p - 1));
    }

    /**
     * Прибавить к числам 3 и получить статистику
     */
    public static IntSummaryStatistics task3Int(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.summarizingInt(p -> p + 3));
    }

    /**
     * Разделить числа на четные и нечетные
     */
    public static Map task4Int(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.partitioningBy(p -> p % 2 == 0));
    }

    /**
     * Получение списка без дубликатов
     */
    public static Set<String> task1Str(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toSet()); // return new HashSet<>(strings); or .distinct().collect(Collectors.toList())
    }

    /**
     * Получить массив строк без дубликатов и в верхнем регистре
     */
    public static String[] task2Str(List<String> strings) {
        return strings.stream()
                .distinct()
                .map(String::toUpperCase)
                .toArray(String[]::new);
    }

    /**
     * Объединить все элементы в одну строку через разделитель:
     * и обернуть тегами <b>… </b>
     */
    public static String task3Str(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(":", "<b>", "</b>"));
    }

    /**
     * Преобразовать в map, где первый символ ключ, второй символ значение
     */
    public static Map task4Str(List<String> strings) {
        return strings.stream()
                .distinct()
                .collect(Collectors.toMap(p -> p.substring(0, 1), p -> p.substring(1, 2)));
    }

    /**
     * Преобразовать в map, сгруппировав по первому символу строки
     */
    public static Map task5Str(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(p -> p.substring(0, 1)));
    }

    /**
     * Преобразовать в map, сгруппировав по первому символу строки и
     * объединим вторые символы через :
     */
    public static Map task6Str(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(p -> p.substring(0, 1), Collectors.mapping(p -> p.substring(1, 2), Collectors.joining(":"))));
    }
}
