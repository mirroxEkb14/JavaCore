package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * дана коллекция строк Arrays.asList(«a1», «a2», «a3», «a1»),
 * и коллекция класса Peoples из прошлых примеров про Sorted и Filter функции.
 */

public class Tasks7 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "a1", "a2", "a3", "a1"
        );

        List<People1> peopleList = Arrays.asList(new People1("Nick", 16, Sex1.MAN), new People1("Dean", 23, Sex1.MAN),
                new People1("Ellen", 42, Sex1.WOMAN), new People1("Baldur", 69, Sex1.MAN));

//        System.out.println(task1(strings));
//        System.out.println(task2(strings));
        System.out.println(task3(peopleList));
    }

    /**
     * Найти максимальное значение среди коллекции строк
     */
    public static String task1(List<String> strings) {
        return strings.stream()
                .max(String::compareTo)
                .get();
    }

    /**
     * Найти минимальное значение среди коллекции строк
     */
    public static String task2(List<String> strings) {
        return strings.stream()
                .min(String::compareTo)
                .get();
    }

    /**
     * Найдем человека с максимальным возрастом
     */
    public static int task3(List<People1> people1) {
        return people1.stream()
                .max(Comparator.comparing(People1::getAge))
                .get()
                .getAge();
    }
}
