package JavaCollections.Tasks.HomeWork.Task2;

import JavaCollections.Tasks.HomeWork.Task2.Car.*;

/**
 * 2. Создать абстрактный класс Car, представляющий собой
 * автомобиль.
 * Добавить в него поля: марка, модель, год выпуска + несколько
 * своих.
 * Создать 4 класса, являющихся наследниками Car.
 * Переопределить во всех 3-х классах методы equals(), hashCode() и
 * toString()
 * Создать класс Garage, хранящий в себе HashMap автомобилей,
 * в котором ключом является объект автомобиля, значением -
 * количество точно таких автомобилей в гараже.
 * Добавить в класс Garage методы для парковки, выезда авто, а также
 * для получения количества определенного вида автомобилей.
 * Продемонстрировать работу гаража.
 */

public class CarDemo {

    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.park(new Truck(Brand.AUDI, Model.HATCHBACK, Color.BLUE, 1986, 10));
        garage.park(new Truck(Brand.BMW, Model.CROSSOVER, Color.BLACK, 2015, 210));
        garage.park(new Truck(Brand.BMW, Model.CROSSOVER, Color.BLACK, 2015, 210));
        garage.park(new Bus(Brand.MERCEDES, Model.SEDAN, Color.RED, 1978, 15));
        garage.park(new RacingCar(Brand.VOLVO, Model.STATION_WAGON, Color.GREEN, 2017, 250));

        System.out.println(garage.toString());


        garage.departure(new RacingCar(Brand.MERCEDES, Model.STATION_WAGON, Color.GREEN, 2017, 350));

        System.out.println(garage.toString());


        System.out.println(garage.getByBrand(Brand.BMW));


        System.out.println(garage.getByModel(Model.CROSSOVER));
    }
}
