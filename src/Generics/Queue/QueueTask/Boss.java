package Generics.Queue.QueueTask;

import java.util.Queue;

public class Boss {
    private Queue toDoQueue;

    public Boss(Queue toDoQueue) {
        this.toDoQueue = toDoQueue;
    }

    public void giveTask(String task) {
        toDoQueue.add(task);
        System.out.println("I gave task: " + task);
    }
}
