package Threads.SynchronizedThreads;

public class SynchronizedKeyword {

    private static final Object lock = new Object(); // the monitor
    private static int counter;

    public static void main(String[] args) throws InterruptedException {

        /* 'counter++' operation seems quite simple but in fact it is more
           difficult. This increment operation consists of three parts:
           1. Get variable value from memory
           2. Increase it by one
           3. Write new value

           So, the problem is that there is a chance that two threads
           can access the method at the same time. For example,
           variable value is 600, 't1' thread calls the method, now
           variable value is 601, then 't2' thread calls the method and
           't1' thread does the same at the same time, now variable value
           is 602 but must be 603

           'synchronized' keyword solves this problem. It takes
            the monitor(just some object) and no thread can access this
            method till the monitor is free

         */

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("'counter' value -> " + counter);
    }

    public static void increment() {
        synchronized (lock) {
            counter++;
        }
    }
}
