package Generics.Set;

public class CarRunner {

    public static void main(String[] args) {
        Car car1 = new Car(1, "zzz");
        Car car2 = new Car(1, "zzz");

        System.out.println(car1.equals(car2));
        System.out.println(car1 == car2);

        System.out.println("car1.hashcode() = " + car1.hashCode());
        System.out.println("car2.hashcode() = " + car2.hashCode());
    }
}
