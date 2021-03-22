package Threads;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedThread {
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    private synchronized void addOne() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (lock1) {
            list1.add("Hello");
        }
    }

    private synchronized void addTwo() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (lock2) {
            list2.add("Hello");
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            addOne();
            addTwo();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThread example = new SynchronizedThread();

        Thread thread1 = new Thread(() -> {
            example.process();
        });

        Thread thread2 = new Thread(() -> {
            example.process();
        });

        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long end = System.currentTimeMillis();

        System.out.println("List 1 size: " + example.list1.size());
        System.out.println("List 2 size: " + example.list2.size());

        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
