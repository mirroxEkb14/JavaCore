package Threads;

public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1: try to catch 'lock1'");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread1: 'lock1' is caught");
            System.out.println("Thread1: try to catch 'lock2'");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread1: 'lock2' is caught");
            }
        }
    }
}

class Thread2 extends Thread {
    // change the order to correct
    @Override
    public void run() {
        System.out.println("Thread2: try to catch 'lock2'");
        synchronized (DeadLockEx.lock2) { // 'lock1'
            System.out.println("Thread2: 'lock2' is caught");
            System.out.println("Thread2: try to catch 'lock1'");
            synchronized (DeadLockEx.lock1) { // 'lock2'
                System.out.println("Thread2: 'lock1' is caught");
            }
        }
    }
}

/*
    Thread1: try to catch 'lock1'
    Thread2: try to catch 'lock2'
    Thread1: 'lock1' is caught
    Thread2: 'lock2' is caught
    Thread1: try to catch 'lock2'
    Thread2: try to catch 'lock1'
 */