package Methods;

public class PrintInReverse {

    public static void main(String[] args) {
        int[] array = new int[50];
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
            value += 2;
        }
        printInLine(array);
        printInLineReverse(array);
    }

    public static void printInLine(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i] + " ";
        }
        System.out.println(result);
    }

    public static void printInLineReverse(int[] array) {
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i] + " ";
        }
        System.out.println(result);
    }
}
