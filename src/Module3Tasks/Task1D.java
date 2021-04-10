package Module3Tasks;

import java.util.Arrays;

public class Task1D {

    /**
     * Создайте массив и инициализируйте его следующими значениями:
     * 5, 24, 3, 66, 38, 16, 27. Проведите сортировку массива и
     * выведите третий элемент массива. Чему он равен?
     */

    public static void main(String[] args) {
        int[] array = {5, 24, 3, 66, 38, 16, 27};
        Arrays.sort(array);
        System.out.println(array[2]);

//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//
//        sortArray(array);
//        System.out.println(Arrays.toString(array));
//    }
//
//    public static void sortArray(int[] array) {
//        int temp;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    temp = array[j + 1];
//                    array[j + 1] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
    }
}
