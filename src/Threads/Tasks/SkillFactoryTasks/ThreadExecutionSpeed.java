package Threads.Tasks.SkillFactoryTasks;

import java.util.*;

public class ThreadExecutionSpeed {

    /**
     * Рассмотрим программу, которая решает следующие задачи:
     * ищет максимум в массиве чисел из 10 миллионов элементов,
     * сортирует другой массив чисел, заполненный от 10 миллионов
     * до 1, и убирает все элементы с последнего индекса из
     * ArrayList, содержащего 10 миллионов чисел.
     * @param args
     */

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // первый ищет максимум в массиве чисел из 10 миллионов элементов;
        new Thread(() -> {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 10000000; i++) {
                numbers.add(i);
            }

            Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
            System.out.println(max);
        }).start();

        // второй сортирует другой массив чисел, заполненный от 10 миллионов до 1;
        new Thread(() -> {
           List<Integer> unSorted = new ArrayList<>();
            for (int i = 10000000; i > 0 ; i--) {
                unSorted.add(i);
            }

            Collections.sort(unSorted);
            System.out.println("Sorted!");
        }).start();

        // третий убирает все элементы с последнего индекса из ArrayList, содержащего 10 миллионов чисел.
        new Thread(() -> {
           List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 10000000; i++) {
                numbers.add(i);
            }

            while (numbers.size() != 0) {
                numbers.remove(numbers.size() - 1);
            }

            System.out.println("Deleted!");
        }).start();

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + "ms");
    }
}