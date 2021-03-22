package JavaCollections.Tasks.HomeWork.Task2;

import JavaCollections.Tasks.HomeWork.Task2.Car.Brand;
import JavaCollections.Tasks.HomeWork.Task2.Car.Car;
import JavaCollections.Tasks.HomeWork.Task2.Car.Model;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private final Map<Car, Integer> cars = new HashMap<>();

    public void park(Car car) {
        Integer oldCount = cars.getOrDefault(car, 0);
        cars.put(car, oldCount + 1);
    }

    public void departure(Car car) {
        Integer oldCount = cars.getOrDefault(car, 0);
        Integer newCount = oldCount == 0? 0: oldCount - 1;

        cars.put(car, newCount);
    }

    public int getByBrand(Brand brand) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry: cars.entrySet()) {
            if (entry.getKey().getBrand() == brand) {
                result += entry.getValue();
            }
        }
        return result;
    }

    public int getByModel(Model model) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry: cars.entrySet()) {
            if (entry.getKey().getModel() == model) {
                result += entry.getValue();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "carMap=" + cars +
                '}';
    }
}
