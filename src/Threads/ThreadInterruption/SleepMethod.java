package Threads.ThreadInterruption;

public class SleepMethod {

    private static int counter;

    public static void main(String[] args) throws InterruptedException {

        /* We don`t know in advance how many 'Not reached yet'
           will be printed to the console because
           'new Thread' and main threads are running in parallel  */
        withoutSleepMethod();

        /* The thread that meets the call of the 'sleep()' method
           sleeps 1 sec while 'new Thread()' is running */
        withSleepMethod();

    }

    public static void withoutSleepMethod() {
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    SleepMethod.counter++;
                }
            }
        }.start();

        while (counter < 100) System.out.println("Not reached yet");

        System.out.println("Reached: " + counter);
    }

    public static void withSleepMethod() throws InterruptedException {
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    SleepMethod.counter++;
                }
            }
        }.start();

        while (counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }

        System.out.println("Reached: " + counter);
    }
}
