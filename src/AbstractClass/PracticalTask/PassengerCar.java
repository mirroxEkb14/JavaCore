package AbstractClass.PracticalTask;

public class PassengerCar extends Car implements Soundable {

    public PassengerCar(String mark, String model, String color) {
        super(mark, model, color);
    }

    @Override
    public void sound() {
        System.out.println("makes a quiet sound...");
    }

    @Override
    public void ride() {
        System.out.println(this.getModel() + " The Passenger Car is riding on the road");
    }
}
