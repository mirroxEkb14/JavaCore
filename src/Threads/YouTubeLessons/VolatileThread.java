package Threads.YouTubeLessons;

public class VolatileThread extends Thread {
    private volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileThread processor = new VolatileThread();
        processor.start();

        Thread.sleep(500);

        processor.shutdown();
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Processing...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}
