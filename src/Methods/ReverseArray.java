package Methods;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
