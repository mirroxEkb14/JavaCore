package FunctionalProgrammingLambda.UsingExample.Stage1;

public class Runner {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();

        switcher.consumer = lamp;

        switcher.switchOn();
    }
}
