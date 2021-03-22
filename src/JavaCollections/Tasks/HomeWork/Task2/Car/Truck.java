package JavaCollections.Tasks.HomeWork.Task2.Car;

import java.util.Objects;

public class Truck extends Car {

    private int liftingAmount;

    public Truck(Brand brand, Model model, Color color, int year, int liftingAmount) {
        super(brand, model, color, year);
        this.liftingAmount = liftingAmount;
    }

    public int getLiftingAmount() {
        return liftingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return liftingAmount == truck.liftingAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), liftingAmount);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "liftingAmount=" + liftingAmount +
                '}';
    }
}
