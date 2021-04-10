package Generics.Queue.QueueTask;

import java.util.Queue;

public class Worker {
    private Queue todoQueue;

    public Worker(Queue todoQueue) {
        this.todoQueue = todoQueue;
    }

    public void takeTask() {
        Object task = todoQueue.poll();
        if (task != null) {
            System.out.println("Im doing task: " + task);
        } else {
            System.out.println("There is no work! *going home*");
        }
    }
}
