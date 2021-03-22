package NestedClasses;

public class ElectricalCarDemo {

    public static void main(String[] args) {
        ElectricalCar electricalCar = new ElectricalCar(1);
        electricalCar.startCar();

        ElectricalCar.Battery battery = new ElectricalCar.Battery();
        battery.charge();
    }
}
