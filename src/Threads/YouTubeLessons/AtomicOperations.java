package Threads.YouTubeLessons;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
    private static AtomicInteger atomicInteger = new AtomicInteger(0); //private static int i;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10000; j++) {
            new myThread().start();
        }

        Thread.sleep(1000);
        System.out.println(atomicInteger.get()); //i
    }

    static class myThread extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet(); //i++;
        }
    }
}
