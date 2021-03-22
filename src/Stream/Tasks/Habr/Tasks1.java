package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://habr.com/ru/company/luxoft/blog/270383/
 *
 * дана коллекция строк Arrays.asList(«a1», «a2», «a3», «a1»),
 * давайте посмотрим как её можно обрабатывать используя методы
 * filter, findFirst, findAny, skip и count:
 */
public class Tasks1 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "a1", "a2", "a3", "a1"
        );

//        System.out.println(task1(strings));
//        System.out.println(task2(strings));
//        System.out.println(task3(strings));
//        System.out.println(task4(strings));
//        System.out.println(task5(strings));
//        System.out.println(task6(strings));
//        System.out.println(task7(strings));
    }

    /**
     * Вернуть количество вхождений объекта «a1»
     * @param strings
     */
    public static long task1(List<String> strings) {
        return strings.stream()
                .filter("a1"::equals) // string -> string.equals("a1")
                .count();
    }

    /**
     * Вернуть первый элемент коллекции или 0, если коллекция пуста
     * @param strings
     */
    public static String task2(List<String> strings) {
        return strings.stream()
                .findFirst()
                .orElse("0");
    }

    /**
     * Вернуть последний элемент коллекции или «empty», если коллекция пуста
     * @param strings
     */
    public static String task3(List<String> strings) {
        return strings.size() != 0?
                strings.stream()
                        .skip(strings.size() - 1)
                        .findAny()
                        .orElse("empty"):
                "empty";
    }

    /**
     * Найти элемент в коллекции равный «a3» или кинуть ошибку
     * @param strings
     */
    public static String task4(List<String> strings) {
        return strings.stream()
                .filter("a3"::equals)
                .findFirst()
                .orElseThrow();
    }

    /**
     * Вернуть третий элемент коллекции по порядку
     * @param strings
     */
    public static String task5(List<String> strings) {
        return strings.size() >= 3?
                strings.stream()
                        .skip(2)
                        .findFirst()
                        .get():
                "List length is lower than 3";
    }

    /**
     * Вернуть два элемента начиная со второго
     * @param strings
     */
    public static List<String> task6(List<String> strings) {
        if (strings.size() >= 3) {
            return strings.stream()
                    .skip(1)
                    .limit(2)
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("List length is lower than 3");
    }

    /**
     * Выбрать все элементы по шаблону
     * @param strings
     * @return
     */
    public static List<String> task7(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("1"))
                .collect(Collectors.toList());
    }
}
