package AbstractClass.PracticalTask;

public class Truck extends Car implements Soundable {

    public Truck(String mark, String model, String color) {
        super(mark, model, color);
    }

    @Override
    public void sound() {
        System.out.println("makes a loud sound...");
    }

    @Override
    public void ride() {
        System.out.println(this.getModel() + " The Truck is riding on the road");
    }
}
