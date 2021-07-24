package JavaTasks.Habr;

import java.util.Arrays;

public class MinMaxAvg {

    public static void main(String[] args) {
        double[] array = new double[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println(getMaxMinAvg(array));
    }

    public static String getMaxMinAvg(double[] array) {
        double max = array[0];
        double min = array[0];
        double avg = 0;

        for (double i : array) {
            if (max < i) max = i;
            if (min > i) min = i;
            avg += i / array.length;
        }

        return String.format("Max: %f\nMin: %f\nAvg: %f", max, min, avg);
    }
}
