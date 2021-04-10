package Module11Task;

import java.util.Objects;

public class DomesticAnimals implements Comparable<DomesticAnimals> {

    private final String animalBreed;
    private final String name;
    private int weight;

    public DomesticAnimals(String animalBreed, String name, int weight) {
        this.animalBreed = animalBreed;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomesticAnimals)) return false;
        DomesticAnimals that = (DomesticAnimals) o;
        return Objects.equals(animalBreed, that.animalBreed) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalBreed, name);
    }

    @Override
    public String toString() {
        return "DomesticAnimals{" +
                "animalBreed='" + animalBreed + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(DomesticAnimals o) {
        return this.weight - o.getWeight();
    }
}
