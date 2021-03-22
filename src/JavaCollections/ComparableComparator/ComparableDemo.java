package JavaCollections.ComparableComparator;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        /*  we compare our cars by car brand in alphabetical order  */

        Set<Car> carSet = new TreeSet<>(Comparator.reverseOrder()); // we can pass 'reverse order'
        carSet.add(new Car("C", "abc", 123L));
        carSet.add(new Car("B", "abc", 1234L));
        carSet.add(new Car("A", "abc", 12345L));

        for (Car car: carSet) {
            System.out.println(car.getBrand());
        }

        System.out.println();

        /*  if we have a list  */

        List<Car> carList = Arrays.asList(
                new Car("C", "abc", 123L),
                new Car("B", "abc", 1234L),
                new Car("A", "abc", 12345L)
        );
        Collections.sort(carList);
        for (Car car: carList) {
            System.out.println(car.getBrand());
        }
    }
}

class Car implements Comparable<Car> {
    private final String brand;
    private final String name;
    private final long serialNumber;

    public Car(String brand, String name, long serialnumber) {
        if (brand == null || name == null || serialnumber == 0) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
        this.name = name;
        this.serialNumber = serialnumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }
}