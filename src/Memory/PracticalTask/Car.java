package Memory.PracticalTask;

import java.util.*;

public class Car {

    // list of serial numbers of cars
    private static final List<String> serialNumbers = new ArrayList<>();

    public Car() {
        // add 100 serial numbers to the list(just take some memory)
        for (int i = 0; i < 100; i++) {
            serialNumbers.add("" + Math.random() * 31 * 1000 + i);
        }
    }

    public SerialNumber getSerialNumber(int index) {
        // return one of 100 collection elements
        return new SerialNumber(serialNumbers.get(index));
    }

    // contains the collection elements
    class SerialNumber {
        final String data;

        public SerialNumber(String data) {
            this.data = data;
        }
    }

    // contains engine type of the car
    static class Engine {
        private final String ENGINE_TYPE;

        public Engine(String ENGINE_TYPE) {
            this.ENGINE_TYPE = ENGINE_TYPE;
        }
    }

    public static void main(String[] args) {
        // fill LinkedList() with 10 serial
        // numbers of cars
        populateList();

        // add engines to map with identical keys
        // (fill a map with duplicates)
        populateMap();
    }

    public static void populateMap() {
        Map<Engine, Integer> engines = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            engines.put(new Engine("GAS"), 1);
        }
        System.out.println(engines.size());
    }

    public static void populateList() {
        // contains serial numbers
        List<Car.SerialNumber> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Car car = new Car(); // added 100 elements to list
            list.add(car.getSerialNumber(i)); // add 10 serial numbers
        }
    }
}
