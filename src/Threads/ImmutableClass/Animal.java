package Threads.ImmutableClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable rules:
 *  1. no setters
 *  2. private final fields
 *  3. final class
 *  4. don`t return mutable objects
 */

public final class Animal {

    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFoods() {
        return new ArrayList<>(favoriteFoods);
    }
}
