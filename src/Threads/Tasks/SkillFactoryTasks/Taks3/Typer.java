package Threads.Tasks.SkillFactoryTasks.Taks3;

public class Typer extends Thread {

    private static final Object lock = new Object();
    private String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                for (int i = 0; i < message.length(); i++) {
                    System.out.print(message.charAt(i));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.err.println("The thread is interrupted");
            }
        }
    }
}
