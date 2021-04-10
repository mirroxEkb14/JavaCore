package Module11Task;

import java.util.Set;
import java.util.TreeSet;

public class AnimalRunner {

    /**
     * Написать класс домашних животных с полями
     * animalBreed, name, weight, реализовать
     * сортировку по значению weight.
     *
     * В отдельном классе реализовать сортировку
     * по длине клички.
     */

    public static void main(String[] args) {
        DomesticAnimals animal1 = new DomesticAnimals("ZZZ", "www", 15);
        DomesticAnimals animal2 = new DomesticAnimals("ZZZ", "yyy", 16);
        DomesticAnimals animal3 = new DomesticAnimals("ZZZ", "zzz", 14);

        Set<DomesticAnimals> animalSet1 = new TreeSet<>();
        animalSet1.add(animal1);
        animalSet1.add(animal2);
        animalSet1.add(animal3);

        System.out.println(animalSet1);

        Set<DomesticAnimals> animalSet2 = new TreeSet<>(new DomesticAnimalsComparator());
        animalSet2.add(animal1);
        animalSet2.add(animal2);
        animalSet2.add(animal3);

        System.out.println(animalSet2);
    }
}
