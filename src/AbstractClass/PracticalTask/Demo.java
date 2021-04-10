package AbstractClass.PracticalTask;

public class Demo {

    public static void main(String[] args) {
        PassengerCar passengerCar = new PassengerCar("Bugatti", "Chiron", "Blue");
        Truck truck = new Truck("Nissan", "Titan", "Red");

        passengerCar.ride();
        passengerCar.sound();

        truck.ride();
        truck.sound();
    }
}