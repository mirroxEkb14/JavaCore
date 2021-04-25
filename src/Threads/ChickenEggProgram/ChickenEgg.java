package Threads.ChickenEggProgram;

import java.util.Random;

public class ChickenEgg extends Thread {

    private final Random random = new Random();

    public ChickenEgg(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                sleep(getTimeSleep());
                System.out.println(getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getTimeSleep() {
        return random.nextInt(300);
    }
}
