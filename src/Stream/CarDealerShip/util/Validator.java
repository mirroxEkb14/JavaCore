package Stream.CarDealerShip.util;

import Stream.CarDealerShip.model.Car;

@FunctionalInterface
public interface Validator {

    // we set this method by ourselves in the 'Main' class
    boolean validate(Car car);

    // this method is set already
    // an expensive car in our dealership is a car that costs more than 5M
    static boolean isExpensive(long cost) {
        return cost > 5_000_000;
    }
}
