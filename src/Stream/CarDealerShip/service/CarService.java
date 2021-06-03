package Stream.CarDealerShip.service;

import Stream.CarDealerShip.model.Car;
import Stream.CarDealerShip.util.Mark;
import Stream.CarDealerShip.util.Model;
import Stream.CarDealerShip.util.Validator;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CarService {

    // car storage
    List<Car> cars = new ArrayList<>();

    // cars in our dealership
    {
        cars.add(new Car(Mark.BMW, Model.I4, 2021, 3_000_000L));
        cars.add(new Car(Mark.TOYOTA, Model.CAMRY, 2011, 10_000_000L));
        cars.add(new Car(Mark.AUDI, Model.A5, 2007, 5_000_000L));
        cars.add(new Car(Mark.AUDI, Model.A5, 2007, 5_000_000L));
        cars.add(new Car(Mark.AUDI, Model.A5, 2007, 5_000_000L));
        cars.add(new Car(Mark.FORD, Model.MUSTANG, 1994, 7_000_000L));
    }

    // change car cost by its id
    // if user passes an id that exceeds the number of cars in dealership,
    // returns empty optional, otherwise returns optional of a car
    // whose value has changed
    public Optional<Car> changeCost(long inputId, long newCost) {
        if (inputId > cars.size())
            return Optional.empty();
        else
            return cars.stream()
                            .filter(car -> car.getId() == inputId)
                            .map(car -> car.setCost(newCost))
                            .findFirst();
    }

    public Optional<Car> getById(long id) {

        // ((int) id -1) because first list index = 0,
        // when car counting starts with 1(first car id = 1)
        if ((int) id > cars.size())
            return Optional.empty();
        else
            return Optional.of(cars.get((int) id - 1));
    }

    // get a car by some sign
    public Optional<Car> getReducedCars(BinaryOperator<Car> binaryOperator) {
        return cars.stream()
                .reduce(binaryOperator);
    }

    // get sorted cars by given comparator
    public List<Car> getSortedCars(Comparator<Car> comparator) {
        return cars.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // here we get cars that match the passed 'validate()' method
    public List<Car> getValidCars(Validator validator) {
        return cars.stream()
                .filter(validator::validate)
                .collect(Collectors.toList());
    }
}
