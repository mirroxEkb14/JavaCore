package Threads.Tasks.ModuleTask2;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private final List<Data> storage = new ArrayList<>();

    public synchronized boolean uploadData(Data inputData) {

        for (Data storageData: storage) {
            if (storageData.getId() == inputData.getId()) {
                System.out.printf("%s -> The data '%d' was NOT loaded\n",
                        Thread.currentThread().getName(), inputData.getId());
                return false;
            }
        }
        storage.add(inputData);
        System.out.printf("%s -> The data '%d' was loaded\n",
                Thread.currentThread().getName(), inputData.getId());
        return true;
    }
}
