package Methods;

public class MinMax {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println(getMax(array));
        System.out.println(getMin(array));
    }

    public static int getMax(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int getMin(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }
}
