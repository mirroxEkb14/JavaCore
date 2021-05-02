package Threads.ModuleTask;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.print("Hello ");
    }
}
