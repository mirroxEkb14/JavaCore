package Stream.CarDealerShip;

import Stream.CarDealerShip.model.Car;
import Stream.CarDealerShip.service.CarService;
import Stream.CarDealerShip.util.Mark;
import Stream.CarDealerShip.util.Model;
import Stream.CarDealerShip.util.Validator;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // the instance of 'CarService' class
        CarService carService = new CarService();

        // set our 'validate()' method
        // in this case, only those cars pass that were produced after 2007
        Validator validator = car -> car.getModelYear() > 2007;

        // this validator checks if the passed car costs more than 5M
        Validator costValidator = car -> Validator.isExpensive(car.getCost());

        System.out.println(carService.getValidCars(validator)); // BMW, TOYOTA
        System.out.println("====================");

        System.out.println(carService.getValidCars(costValidator)); // TOYOTA, FORD
        System.out.println("====================");

        // sort by model year(from more to less)
        System.out.println(carService.getSortedCars(
                (car1, car2) -> Period.between(
                        LocalDate.of(car1.getModelYear(), Month.JUNE, 2), LocalDate.of(car2.getModelYear(), Month.JUNE, 2))
                        .getYears())); // [BMW, TOYOTA, AUDI, AUDI, AUDI, FORD]
        System.out.println("====================");

        // get the oldest car(by model year)
        System.out.println(carService.getReducedCars(
                (car1, car2) -> Period.between(
                        LocalDate.of(car1.getModelYear(), Month.JUNE, 2), LocalDate.of(car2.getModelYear(), Month.JUNE, 2))
                        .getYears() > 0 ? car1 : car2)); // FORD
        System.out.println("====================");

        // get a car by 'id'
        carService.getById(5L)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No car with such id")
                ); // AUDI
        System.out.println("====================");

        // change Ford cost from 7M to 20M
        System.out.println(carService.changeCost(6, 20_000_000)); // FORD
    }
}
