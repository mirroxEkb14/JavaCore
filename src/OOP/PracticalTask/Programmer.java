package OOP.PracticalTask;

public class Programmer extends Person {

    public Programmer(String name, int age) {
        super(name, "Programmer", age);
    }

    @Override
    public void doWork() {
        System.out.println(super.getName() + " is coding...");
    }
}
