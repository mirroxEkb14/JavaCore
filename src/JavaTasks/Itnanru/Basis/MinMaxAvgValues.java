package JavaTasks.Itnanru.Basis;

import java.util.Arrays;

public class MinMaxAvgValues {

    /**
     * Заполните массив случайным числами и выведете
     * максимальное, минимальное и среднее значение.
     *
     * Для генерации случайного числа используйте метод
     * Math.random(), который возвращает значение в промежутке [0, 1].
     */

    public static void main(String[] args) {
        double[] doubleArray = new double[100];

        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Math.random();
        }

        double min = doubleArray[0];
        double max = doubleArray[0];
        double avg = 0;
        for (int i = 0; i < doubleArray.length; i++) {
            if (max < doubleArray[i]) max = doubleArray[i];
            if (min > doubleArray[i]) min = doubleArray[i];
            avg += doubleArray[i] / doubleArray.length;
        }

        System.out.printf("Array: %s\nMin value: %f\nMax value: %f\nAvg value: %f\n", Arrays.toString(doubleArray), min, max, avg);
    }
}
