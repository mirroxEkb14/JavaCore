package JavaTasks.Different;

import java.util.Scanner;

public class MultidimensionalArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of rows:");
        int rowNumber = scanner.nextInt();

        System.out.println("Number of columns:");
        int columnNumber = scanner.nextInt();

        String[][] array = new String[rowNumber][columnNumber];

        printArray(array);

        System.out.println("Index of row I should write a value in:");
        int rowIndex = scanner.nextInt();

        System.out.println("Index of column:");
        int columnIndex = scanner.nextInt();

        System.out.println("The value itself:");
        String value = scanner.next();

        array[rowIndex][columnIndex] = value;

        printArray(array);
    }

    public static void printArray(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
