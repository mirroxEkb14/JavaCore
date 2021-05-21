package Threads.Tasks.ModuleTask1;

public class Demo {

    // https://docs.google.com/document/d/1FhYYPFyaEFWeCrFIW_cR9hTvTIo6ybiezgBH7AisZpU/edit?usp=sharing

    public static void main(String[] args) throws InterruptedException {
        Thread worldThread = new Thread() {
            public void run() {
                System.out.println("world!");
            }
        };

        /* all these threads are working in parallel, so we cannot
           predict what the result will be:
           "Hello Java world!", "Java Hello world!" or "Hello world!
                                                        Java ".
           We know two methods how to make the "Hello Java world!" variant */
//        new HelloThread().start();
//        new Thread(new JavaThread()).start();
//        worldThread.start();

        // first method -> sleep()
        new HelloThread().start();
        Thread.sleep(100);

        new Thread(new JavaThread()).start();
        Thread.sleep(100);

        worldThread.start();

        // second method
        Thread helloThread = new HelloThread();
        helloThread.start();
        helloThread.join();

        Thread javaThread = new Thread(new JavaThread());
        javaThread.start();
        javaThread.join();

        worldThread.start();

    }
}
