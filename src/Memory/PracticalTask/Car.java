package Memory.PracticalTask;

import java.util.*;

public class Car {

    /*
        Inner classes:
            Each non-static class has a hidden link to a class in which it is located.
            So, if the object of outer class ends its work, it is unavailable for GC,
            because non-static class has a link to this class(if some class is
            referenced by other objects, it is unavailable for GC)

        Static fields:
            Static fields store the data till ending the program.
            After 'createMemoryLeak' method 'Car' objects will be deleted
            but the data that are stored in 'serialNumbers' will not

        equals() and hashcode() methods:
            HashSet and HashMap use these methods to avoid duplicates, so if we have
            some entity class(Person, Car, User, etc.) we have to override
            equals() and hashcode() methods. If these methods are not overridden,
            we will have duplicates in maps and sets
     */

    // list of serial numbers of cars
    private final List<String> serialNumbers = new ArrayList<>(); // make 'static' for memory leak

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
    static class SerialNumber { // make 'non-static' for memory leak
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

        // methods are overridden to avoid duplicates
        // in maps and sets
        @Override
        public boolean equals(Object o) { // delete method for memory leak
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Engine engine = (Engine) o;
            return Objects.equals(ENGINE_TYPE, engine.ENGINE_TYPE);
        }

        @Override
        public int hashCode() { // delete method for memory leak
            return Objects.hash(ENGINE_TYPE);
        }
    }

    public static void main(String[] args) {
        // 'Static fields', 'Inner static classes' cases
        staticMemoryLeak();

        // 'equals() and hashcode() methods' case
        entityMemoryLeak();
    }

    public static void entityMemoryLeak() {
        Map<Engine, Integer> engines = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            // the keys are the same
            engines.put(new Engine("GAS"), 1);
        }
        // returns '1' if equals() and hashcode() are overridden,
        // '10' otherwise
        System.out.println(engines.size());
    }

    public static void staticMemoryLeak() {
        // contains serial numbers
        List<Car.SerialNumber> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Car car = new Car(); // added 100 elements to list
            list.add(car.getSerialNumber(i)); // add 10 serial numbers
        }
    }
}
