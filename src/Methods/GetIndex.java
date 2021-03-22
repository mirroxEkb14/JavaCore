package Methods;

public class GetIndex {

    public static void main(String[] args) {
        int[] array = {15, 34, 5, 3, -11, 567, 2, 547, 2, 0, -12, 35};
        int number = 567;
        int index = getIndex(array, number);
        System.out.println("Index of number in array = " + index);
    }

    public static int getIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
