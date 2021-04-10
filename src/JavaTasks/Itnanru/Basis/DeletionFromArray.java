package JavaTasks.Itnanru.Basis;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DeletionFromArray {

    /**
     * Дан массив целых чисел и ещё одно целое число.
     * Удалите все вхождения этого числа из массива
     * (пропусков быть не должно).
     */

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int value = 3;

        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }
        }
        int[] editedNums = Arrays.copyOf(nums, nums.length - offset);

        System.out.println(Arrays.toString(editedNums));
    }
}
