package Threads.SynchronizedThreads.VolatileKeyword;

public class MyThread extends Thread {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        this.running = false;
    }
}
