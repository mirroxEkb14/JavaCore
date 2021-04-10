package Generics.Set;

import java.util.Objects;

public class Car {

    private final int id;
    private String name;

    public Car(int id, String name) {
        if (id <= 0) throw new IllegalArgumentException();
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
