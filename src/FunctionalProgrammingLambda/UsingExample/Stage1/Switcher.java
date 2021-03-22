package FunctionalProgrammingLambda.UsingExample.Stage1;

public class Switcher {

    /* This is the filed with an interface type
        It contains a reference to an object of any class
            that implements this interface  */
    public ElectricityConsumer consumer;

    public void switchOn() {
        System.out.println("Switcher is on");

        if (consumer != null) consumer.electricityOn();
    }
}
