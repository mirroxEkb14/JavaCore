package Memory.PracticalTask;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Double> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        populateList();
    }

    public static void populateList() {

        for (int i = 0; i < 100_000_000; i++) {
            list.add(Math.random());
        }
    }
}
