package Methods;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6};
        int number = 0;
        System.out.println(binarySearch(array, number));
    }

    public static int binarySearch(int[] array, int number) {
        int lower_bound = 0;
        int upper_bound = array.length;

        while (lower_bound <= upper_bound) {
            int center = (lower_bound + upper_bound) / 2;

            if (array[center] == number) {
                return center;
            } else if (array[center] > number) {
                upper_bound = center;
            } else if (array[center] < number) {
                lower_bound = center;
            }
        }
        return -1;
    }
}
