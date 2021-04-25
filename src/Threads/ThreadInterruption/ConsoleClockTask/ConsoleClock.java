package Threads.ThreadInterruption.ConsoleClockTask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleClock extends Thread {

    Date curDate;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                curDate = new Date();
                System.out.println(sdf.format(curDate));
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                break;
            }
        }
    }
}
