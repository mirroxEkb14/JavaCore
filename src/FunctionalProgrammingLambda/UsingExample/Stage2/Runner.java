package FunctionalProgrammingLambda.UsingExample.Stage2;

public class Runner {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        // event subscribe
        switcher.addListener(lamp);
        switcher.addListener(radio);


        /*   when we turn on the switcher, the fire occurs */
//        class Fire implements ElectricityConsumer {
//
//            @Override
//            public void electricityOn() {
//                System.out.println("Fire");
//            }
//        }
//        switcher.addListener(new Fire());

        // anonymous class
//        switcher.addListener(new ElectricityConsumer() {
//            @Override
//            public void electricityOn() {
//                System.out.println("Fire");
//            }
//        });

        // with lambda
        switcher.addListener(() -> System.out.println("Fire"));

        switcher.switchOn();
    }
}
