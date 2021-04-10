package Exceptions.ModuleTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {

    /**
     * Даны 2 динамических массива случайных вещественных чисел в диапазоне
     * от 0 до 100. Произвести деление каждого значения из первого массива
     * на соответствующее по индексу значение второго массива.
     * При результате деления меньше 1 выбросить Exception.
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Random random = new Random();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list1.add(random.nextInt());
            list2.add(random.nextInt());
        }

        for (int j = 0; j < 100; j++) {
            if (list1.get(j) / list2.get(j) < 1) {
                throw new Exception("Exception created");
            }
        }
    }
}
