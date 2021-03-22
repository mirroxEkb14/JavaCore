package Threads;

public class StartThread extends Thread {
    public static void main(String[] args) {
        // 3 ways to start a thread

        new Thread(() -> System.out.println("Example using lambda")).start();
        new ThreadExample().start();
        new Thread(new RunnableExample()).start();
    }
}

class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Example extending Thread class");
    }
}

class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Example implementing Runnable interface");
    }
}