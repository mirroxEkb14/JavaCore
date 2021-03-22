package Methods;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {1, 54, -1, 54, 0, 434};
        int number = -1;

        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                System.out.println(i);
            }
        }
    }
}
