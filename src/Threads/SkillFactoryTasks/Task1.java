package Threads.SkillFactoryTasks;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Task1 {

    /**
     * В одном потоке в бесконечном цикле добавлять случайные элементы
     * в очередь в диапазоне 0–100 ( вместимость очереди — 10). Во втором
     * потоке каждые 100 мс генерировать случайные целые числа в диапазоне
     * 0–10. При получении во втором потоке числа 5, удалить из очереди
     * первый элемент.
     */

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10);
        Random random = new Random();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        queue.put(random.nextInt(100));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        sleep(100);
                        if (random.nextInt(10) == 5) System.out.println("First: " + queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
