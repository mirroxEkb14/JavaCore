package JavaTasks.Module3Tasks;

import java.util.Arrays;

public class Task5 {

    /**
     * В классе Main объявлен массив numbers.
     * Заполните его числами так, чтобы содержимое
     * выглядело следующим образом: [1, -2, 3, -4, 5, …, -98, 99, -100].
     * Советуем использовать циклы. Не меняйте модификаторы доступа переменных!
     */

    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                numbers[i] = ++i;
            } else {
                numbers[i] = -++i;
            }
            i--;
        }

        System.out.println(Arrays.toString(numbers));
    }
}
