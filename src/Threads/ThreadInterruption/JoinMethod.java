package Threads.ThreadInterruption;

public class JoinMethod {

    private static int counter;

    public static void main(String[] args) throws InterruptedException {

        /* The threads are running in parallel, so
           'counter' can be printed before it is 100 */
        withoutJoinMethod();

        /* 'thread.join();' -> main thread is waiting for
           the 'thread' thread, then main thread continues
           its work */
        withJoinMethod();
    }

    public static void withoutJoinMethod() {
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter++;
                }
            }
        }.start();

        System.out.println("Counter value: " + counter);
    }

    public static void withJoinMethod() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter++;
                }
            }
        };

        thread.start();
        thread.join();

        System.out.println("Counter value: " + counter);
    }
}
