package Threads.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {

    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("preparing to start...");
        try {
            countDownLatch.await();
            System.out.println("STARTED");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
