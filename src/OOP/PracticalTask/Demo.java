package OOP.PracticalTask;

public class Demo {

    // https://docs.google.com/document/d/1NkYgnrF4QusSwS5uRafxee-xG_MiMGuuQGqPRWWhwU4/edit?usp=sharing

    public static void main(String[] args) {
        Person programmer = new Programmer("Nikolas",  21);
        Person deliveryMan = new Deliveryman("Alejandro", 32);

        programmer.doWork();
        deliveryMan.doWork();
    }
}
