package FunctionalProgrammingLambda.UsingExample.Stage2;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private List<ElectricityConsumer> listeners =
            new ArrayList<>();

    public void addListener(ElectricityConsumer listener) {
        if (listener == null) {
            throw new IllegalArgumentException("The value is null");
        } else if (listeners.contains(listener)) {
            throw  new RuntimeException("The value already exists");
        }
        listeners.add(listener);
    }

    public void removeListener(ElectricityConsumer listener) {
        if (listener == null) {
            throw new IllegalArgumentException("The value is null");
        } else if (!listeners.contains(listener)) {
            throw new RuntimeException("Passed value is not in the collection");
        }
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Switcher is on");

        for (ElectricityConsumer consumer: listeners) {
            consumer.electricityOn();
        }
    }
}
