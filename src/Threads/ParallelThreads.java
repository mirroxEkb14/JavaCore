package Threads;

public class ParallelThreads {
    // увеличение счетчика в двух параллельно работающих потоках
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ParallelThreads example = new ParallelThreads();
        example.doWork();
    }

    private synchronized void increment() {
        count++;
    }

    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter value: " + count);
    }
}
