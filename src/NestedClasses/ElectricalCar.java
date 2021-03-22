package NestedClasses;

public class ElectricalCar {

    private int id;

    //non-static nested class
    private class Motor {
        public void startMotor() {
            System.out.println("The motor " + id + " is starting...");
        }
    }

    //static nested class
    public static class Battery {
        public void charge() {
            System.out.println("The battery is charging...");
        }
    }

    public ElectricalCar(int id) {
        this.id = id;
    }

    public void startCar() {
        new Motor().startMotor();
        System.out.println("The car " + id + " is starting...");
    }

    public int getId() {
        return id;
    }
}
