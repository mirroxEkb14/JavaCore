package Threads;

public class StopThread {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                StopThread.counter++;
            }
        }).start();

        while (StopThread.counter < 500) {
            System.out.println("not reached yet");
            Thread.sleep(100);
        }

        System.out.println("reached");
    }
}
