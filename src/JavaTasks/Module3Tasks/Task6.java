package JavaTasks.Module3Tasks;

import java.util.Arrays;

public class Task6 {

    /**
     * В классе Main объявлен массив numbers.
     * Заполните его весь (30 ячеек) числами Фибоначчи.
     * Числа Фибоначчи определяются так: первые два числа
     * равны единице, а каждое последующее — сумме двух
     * предыдущих. Начало последовательности выглядит так: 1, 1, 2, 3, 5, 8, 13, 21, …
     */

    public static void main(String[] args) {
        int[] numbers = new int[30];
        numbers[0] = numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.println(Arrays.toString(numbers));
    }
}
