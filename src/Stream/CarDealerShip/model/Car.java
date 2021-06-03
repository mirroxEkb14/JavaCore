package Stream.CarDealerShip.model;

import Stream.CarDealerShip.util.Mark;
import Stream.CarDealerShip.util.Model;

public class Car {

    private static long totalCars = 0;
    private final long id;
    private final Mark mark;
    private final Model model;
    private final int modelYear;
    private long cost;

    public Car(Mark mark, Model model, int modelYear, long cost) {
        this.id = ++totalCars;
        this.mark = mark;
        this.model = model;
        this.modelYear = modelYear;
        this.cost = cost;
    }

    public Mark getMark() {
        return mark;
    }

    // usually setter return 'void' but in this case,
    // in 'changeCost' method we need 'setCost' method
    // to return 'Car' object
    public Car setCost(long cost) {
        this.cost = cost;
        return this;
    }

    public long getId() {
        return id;
    }

    public int getModelYear() {
        return modelYear;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark=" + mark +
                ", model=" + model +
                ", modelYear=" + modelYear +
                ", cost=" + cost +
                '}' + "\n";
    }
}
