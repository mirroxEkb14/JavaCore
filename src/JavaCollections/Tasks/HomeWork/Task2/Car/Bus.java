package JavaCollections.Tasks.HomeWork.Task2.Car;

import java.util.Objects;

public class Bus extends Car {

    private int passengerAmount;

    public Bus(Brand brand, Model model, Color color, int year, int passengerAmount) {
        super(brand, model, color, year);
        this.passengerAmount = passengerAmount;
    }

    public int getPassengerAmount() {
        return passengerAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return passengerAmount == bus.passengerAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerAmount);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passengerAmount=" + passengerAmount +
                '}';
    }
}
