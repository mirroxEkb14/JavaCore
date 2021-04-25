package Threads.ThreadInterruption.ConsoleClockTask;

public class Demo {

    /**
     * Должна в течение примерно трех секунд выдать следующее:
     * 08:09:43
     * 08:09:44
     * 08:09:45
     * The clock was stopped
     *
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        ConsoleClock cc = new ConsoleClock();
        cc.start();
        Thread.sleep(3000);
        cc.interrupt();
    }
}
