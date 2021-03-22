package Methods;

public class FindOddEven {

    public static void main(String[] args) {
        int[] array = {15, 34, 5, 3, -11, 567, 2, 547, 2, 0, -12, 35};
        printOdd(array);
        System.out.println();
        printEven(array);
    }

    public static void printOdd(int[] array) {
        for (int number: array) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
    }

    public static void printEven(int[] array) {
        for (int number: array) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }
}
