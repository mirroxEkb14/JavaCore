package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import Stream.Tasks.Habr.StreamClassMethods.People;
import Stream.Tasks.Habr.StreamClassMethods.Sex;

/**
 * даны две коллекции коллекция строк Arrays.asList(«a1», «a4», «a3», «a2», «a1», «a4») и
 * коллекция людей класса People (с полями name — имя, age — возраст, sex — пол),
 * вида Arrays.asList( new People(«Вася», 16, Sex.MAN), new People(«Петя», 23, Sex.MAN),
 * new People(«Елена», 42, Sex.WOMEN), new People(«Иван Иванович», 69, Sex.MAN)).
 * Давайте посмотрим примеры как их можно сортировать:
 */

public class SortDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "a1", "a4", "a3", "a2", "a1", "a4"
        );

        List<People> people = Arrays.asList( new People("Nick", 16, Sex.MAN), new People("Dean", 23, Sex.MAN),
                new People("Ellen", 42, Sex.WOMAN), new People("John", 69, Sex.MAN));

//        System.out.println(task1(strings));
//        System.out.println(task2(strings));
//        System.out.println(task3(strings));
//        System.out.println(task4(strings));
//        System.out.println(task5(people));
        System.out.println(task6(people));
    }

    /**
     * Отсортировать коллекцию строк по алфавиту
     */
    public static List<String> task1(List<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Отсортировать коллекцию строк по алфавиту в обратном порядке
     */
    public static List<String> task2(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.reverseOrder()) // sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
    }

    /**
     * Отсортировать коллекцию строк по алфавиту и убрать дубликаты
     */
    public static List<String> task3(List<String> strings) {
        return strings.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Отсортировать коллекцию строк по алфавиту
     * в обратном порядке и убрать дубликаты
     */
    public static List<String> task4(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Отсортировать коллекцию людей по имени
     * в обратном алфавитном порядке
     */
    public static List<People> task5(List<People> people) {
        return people.stream()
                .sorted(Comparator.comparing(People::getName)) // (p1, p2) -> p1.getName().compareTo(p2.getName())
                .collect(Collectors.toList());
    }

    /**
     * Отсортировать коллекцию людей сначала по полу,
     * а потом по возрасту
     */
    public static List<People> task6(List<People> people) {
        return people.stream()
                .sorted(Comparator.comparing(People::getSex))
                .sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());
    }
}