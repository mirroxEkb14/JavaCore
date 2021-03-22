package Stream.Demo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Nick", 28),
                new Person("Ellen", 23),
                new Person("Dean", 17)
        );

        /*  Example 1: print list of people  */

        printWithoutStream(people);  //without stream
        printWithStream(people); //with stream

        System.out.println();


        /*  Example 2: print sorted(by name) people only 18+  */

        only18WithoutStream(people); //without stream
        only18WithStream(people); //with stream

        System.out.println();


        /*  Example 3: print arithmetic mean of adults  */

        averageWithoutStream(people);
        averageWithStream(people);
    }

    public static void averageWithoutStream(List<Person> people) {
        int adultCounter = 0;
        int generalAge = 0;
        for (Person person: people) {
            if (person.getAge() >= 18) {
                generalAge += person.getAge();
                adultCounter++;
            }
        }
        System.out.println("Average: " + (double) generalAge / adultCounter);
    }

    public static void averageWithStream(List<Person> people) {
        double average = people.stream()
                .filter(person -> person.getAge() >= 18)
                .mapToInt(Person::getAge) // person -> person.getAge()
                .average().getAsDouble();

        System.out.println("Average: " + average);
    }

    public static void only18WithoutStream(List<Person> people) {
        List<Person> peopleTemp = new LinkedList<>();
        for (Person person: people) {
            if (person.getAge() >= 18) {
                peopleTemp.add(person);
            }
        }
        peopleTemp.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }); // lambda: (o1, o2) -> o1.getName().compareTo(o2.getName()) / Comparator.comparing(Person::getName)

        for (Person person: peopleTemp) {
            System.out.println(person);
        }
    }

    public static void only18WithStream(List<Person> people) {
        people.stream()
                .filter(person -> person.getAge() >= 18)
                .sorted(Comparator.comparing(Person::getName)) // (p1, p2) -> p1.getName().compareTo(p2.getName())
                .forEach(System.out::println);
    }

    public static void printWithoutStream(List<Person> people) {
        for (Person person: people) {
            System.out.println(person);
        }
    }

    public static void printWithStream(List<Person> people) {
        people.forEach(System.out::println);

//        people.forEach(
//                (Person person) -> { System.out.println(person); });
//
//        people.forEach(person -> System.out.println(person));
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }
}