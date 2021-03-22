package Stream.StreamMethods;

import java.util.Comparator;
import java.util.List;

public class SortedMethod {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ccc", 3),
                new Person("Bbbb", 22),
                new Person("Aaaa", 1)
        );

        /*  Without "Comparator" implementation in the "Person" class  */

        // 1 by name
        people.stream()
                .sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .forEach(System.out::println);

        // 2 by name
        people.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()));

        // 3 by name
        people.stream()
                .sorted(Comparator.comparing(Person::getName));


        // by age
        people.stream()
                .sorted(Comparator.comparing(Person::getAge));


        /*  Comparator.naturalOrder() / Comparator.reverseOrder()  */
        List<Integer> integers = List.of(
                1, 3, 2, 4
        );
        integers.stream()
                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }
}