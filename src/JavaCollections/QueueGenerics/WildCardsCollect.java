package JavaCollections.QueueGenerics;

import Threads.ParallelThreads;

import java.util.ArrayList;
import java.util.List;

public class WildCardsCollect {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1));
        animals.add(new Animal(2));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        test(animals);
        test(dogs);
    }

    /* <?> - wildcard
        with the help of 'extends Animal' we can access the variables directly
     */
    public static void test(List<? extends Animal> list) {
        for (Animal animal: list) {
            animal.eat();
        }
    }
}

class Animal {
    private int id;

    public Animal() {
    }

    public Animal(int id) {
        this.id = id;
    }

    public void eat() {
        System.out.println("animal is eating...");
    }

    public String toString() {
        return String.valueOf(id);
    }
}

class Dog extends Animal {
}