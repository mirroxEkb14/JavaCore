package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import Stream.Tasks.Habr.StreamClassMethods.People;
import Stream.Tasks.Habr.StreamClassMethods.Sex;

/**
 * дана коллекция строк Arrays.asList(«a1», «a2», «a3», «a1»),
 * и коллекция класса Peoples из прошлых примеров про Sorted и Filter функции.
 */

public class MinMaxDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "a1", "a2", "a3", "a1"
        );

        List<People> peopleList = Arrays.asList(new People("Nick", 16, Sex.MAN), new People("Dean", 23, Sex.MAN),
                new People("Ellen", 42, Sex.WOMAN), new People("Baldur", 69, Sex.MAN));

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
    public static int task3(List<Stream.Tasks.Habr.StreamClassMethods.People> people1) {
        return people1.stream()
                .max(Comparator.comparing(Stream.Tasks.Habr.StreamClassMethods.People::getAge))
                .get()
                .getAge();
    }
}
