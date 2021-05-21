package Threads.Tasks.ModuleTask2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Server {

    private LinkedBlockingDeque<Data> storage = new LinkedBlockingDeque<>();
    private final long START_TIME;

    public void uploadData(Data data) {
        while (System.currentTimeMillis() - START_TIME <= 5000) {
            Data storageData = null;
            try {
                storageData = storage.poll(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (storageData != null) {

                if (storageData.getId() != data.getId()) {
                    addElement(data);
                    System.out.printf("The data '%d' was loaded\n", data.getId());
                } else {
                    System.out.printf("The data '%d' was NOT loaded\n", data.getId());
                }
            }
        }
    }

    public void addElement(Data data) {
        try {
            storage.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Server() {
        START_TIME = System.currentTimeMillis();
    }

//    public synchronized boolean checkData(Data inputData) {
//        for (Data storageData: storage) {
//            if (storageData.getId() == inputData.getId()) return true;
//        }
//        return false;
//    }
}
