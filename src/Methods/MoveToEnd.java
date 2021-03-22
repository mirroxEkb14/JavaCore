package Methods;

public class MoveToEnd {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 0, 6, 10, 340, 5, 6, 0, 25, 0, 8, 7, 3, 44, 1, 1, 0, 6, 4};
        printInLine(moveZeros(array));
    }

    public static int[] moveZeros(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] == 0 && array[j + 1] != 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void printInLine(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i] + " ";
        }
        System.out.println(result);
    }
}
