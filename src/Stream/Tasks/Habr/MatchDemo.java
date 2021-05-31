package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.List;

/**
 * дана коллекция строк Arrays.asList(«a1», «a2», «a3», «a1»),
 * давайте посмотрим, как её можно обрабатывать используя Match функции
 */

public class MatchDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "a1", "a2", "a3", "a1"
        );

//        System.out.println(task1(strings));
//        System.out.println(task2(strings));
//        System.out.println(task3(strings));
    }

    /**
     * Найти существуют ли хоть один «a1» элемент в коллекции
     */
    public static boolean task1(List<String> strings) {
        return strings.stream()
                .anyMatch("a1"::equals); // s -> s.equals("a1")
    }

    /**
     * Найти есть ли символ «1» у всех элементов коллекции
     */
    public static boolean task2(List<String> strings) {
        return strings.stream()
                .allMatch(s -> s.contains("1"));
    }

    /**
     * Проверить что не существуют ни одного «a7» элемента в коллекции
     */
    public static boolean task3(List<String> strings) {
        return strings.stream()
                .noneMatch("a7"::equals);
    }
}
