package JavaTasks.Module3Tasks;

import java.util.Arrays;

public class Task7 {

    /**
     * В классе Main объявлен двумерный зубчатый массив ints
     * и целое число size (> 2). Вам нужно сформировать и
     * вывести массив, представляющий треугольник Паскаля.
     * Не нужно центрировать вывод.
     */

    public static short size = 3;
    public static int[][] ints = new int[size][];

    public static void main(String[] args) {
        ints[0] = new int[]{1};
        ints[1] = new int[]{1, 1};

        for (int i = 2; i < size; i++) {
            int[] line = new int[i + 1];
            line[0] = line[i] = 1;

            for (int j = 1; j < line.length - 1; j++) {
                line[j] = ints[i - 1][j - 1] + ints[i - 1][j];
            }

            ints[i] = line;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
