package JavaCollections.Tasks.HomeWork.Task2.Car;

import java.util.Objects;

public class RacingCar extends Car {

    private int maxSpeed;

    public RacingCar(Brand brand, Model model, Color color, int year, int maxSpeed) {
        super(brand, model, color, year);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RacingCar racingCar = (RacingCar) o;
        return maxSpeed == racingCar.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}
