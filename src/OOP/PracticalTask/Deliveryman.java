package OOP.PracticalTask;

public class Deliveryman extends Person {

    public Deliveryman(String name, int age) {
        super(name, "Deliveryman", age);
    }

    @Override
    public void doWork() {
        System.out.println(super.getName() + " is delivering food...");
    }
}
