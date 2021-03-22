package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * дана коллекция класс People (с полями name — имя, age — возраст, sex — пол),
 * вида Arrays.asList( new People(«Вася», 16, Sex.MAN), new People(«Петя», 23, Sex.MAN),
 * new People(«Елена», 42, Sex.WOMEN), new People(«Иван Иванович», 69, Sex.MAN)).
 * Давайте посмотрим примеры как работать с таким классом:
 */

public class Tasks2 {

    public static void main(String[] args) {
        List<People1> peopleList = Arrays.asList(new People1("Nick", 16, Sex1.MAN), new People1("Dean", 23, Sex1.MAN),
                new People1("Ellen", 42, Sex1.WOMAN), new People1("Baldur", 69, Sex1.MAN));

//        System.out.println(task1(peopleList));
//        System.out.println(task2(peopleList));
        System.out.println(task3(peopleList));
    }

    /**
     * Выбрать мужчин-военнообязанных (от 18 до 27 лет)
     */
    public static List<People1> task1(List<People1> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSex() == Sex1.MAN)
                .collect(Collectors.toList());
    }

    /**
     * Найти средний возраст среди мужчин
     */
    public static double task2(List<People1> people) {
        return people.stream()
                .filter(p -> p.getSex() == Sex1.MAN)
                .mapToInt(People1::getAge)
                .average()
                .getAsDouble();
    }

    /**
     * Найти кол-во потенциально работоспособных людей в выборке
     * (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
     */
    public static long task3(List<People1> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getAge() <= 55 && p.getSex() == Sex1.WOMAN ||
                        p.getAge() <= 60 && p.getSex() == Sex1.MAN)
                .count();
    }
}

class People1 {

    private String name;
    private int age;
    private Sex1 sex;

    public People1(String name, int age, Sex1 sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex1 getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

enum Sex1 {
    MAN,
    WOMAN
}