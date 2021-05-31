package Stream.Tasks.Habr.StreamClassMethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * дана коллекция класс People (с полями name — имя, age — возраст, sex — пол),
 * вида Arrays.asList( new People(«Вася», 16, Sex.MAN), new People(«Петя», 23, Sex.MAN),
 * new People(«Елена», 42, Sex.WOMEN), new People(«Иван Иванович», 69, Sex.MAN)).
 * Давайте посмотрим примеры как работать с таким классом:
 */

public class Demo {

    public static void main(String[] args) {
        List<People> peopleList = Arrays.asList(new People("Nick", 16, Sex.MAN), new People("Dean", 23, Sex.MAN),
                new People("Ellen", 42, Sex.WOMAN), new People("Baldur", 69, Sex.MAN));

//        System.out.println(task1(peopleList));
//        System.out.println(task2(peopleList));
        System.out.println(task3(peopleList));
    }

    /**
     * Выбрать мужчин-военнообязанных (от 18 до 27 лет)
     */
    public static List<People> task1(List<People> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSex() == Sex.MAN)
                .collect(Collectors.toList());
    }

    /**
     * Найти средний возраст среди мужчин
     */
    public static double task2(List<People> people) {
        return people.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
    }

    /**
     * Найти кол-во потенциально работоспособных людей в выборке
     * (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
     */
    public static long task3(List<People> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getAge() <= 55 && p.getSex() == Sex.WOMAN ||
                        p.getAge() <= 60 && p.getSex() == Sex.MAN)
                .count();
    }
}

