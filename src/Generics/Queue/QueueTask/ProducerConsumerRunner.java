package Generics.Queue.QueueTask;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumerRunner {

    public static void main(String[] args) {
        int numberOfTasks = 5;
        Queue toDoQueue = new ArrayDeque(numberOfTasks);

        Boss boss = new Boss(toDoQueue);
        Worker worker = new Worker(toDoQueue);

        for (int i = 1; i <= numberOfTasks; i++) {
            boss.giveTask("Task number " + i);
        }

        System.out.println("The boss finished giving tasks");

        for (int i = 1; i <= numberOfTasks + 1; i++) {
            worker.takeTask();
        }
    }
}
