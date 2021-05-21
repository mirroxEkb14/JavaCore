package Threads.Tasks.ModuleTask2;

import java.util.Random;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Server server = new Server();

        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    server.uploadData(new Data(random.nextInt(2)));
                }
            }.start();
        }
    }
}
