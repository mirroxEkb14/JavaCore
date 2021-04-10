package JavaTasks.Itnanru.Basis;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Реализуйте алгоритм сортировки пузырьком
     * для сортировки массива
     * @param args
     */

    public static void main(String[] args) {
        int[] intArray = {5, 7, -1, 0, 2, 50, -1000};

        int temp;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray.length - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
