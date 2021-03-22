package Projects.Calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // object of class 'Scanner'
        System.out.println("Enter an expression like this: 1 + 1");

        while (true) { // we ask the user for data till he enters it correctly

            String[] userInput = scanner.nextLine().split(" "); // read user input

            if (userInput[0].equals("q") || userInput[0].equals("Q")) { // if 'q' - exit the program
                System.out.println("\nbye-bye...");
                break;

            } else if (checkInput(userInput)) { // if user entered everything correctly
                doMath(userInput);
                break;
            }
        }
    }

    // make calculations
    public static void doMath(String[] userInput) {
        int result = switch (userInput[1]) {
            case "+" -> Integer.parseInt(userInput[0]) + Integer.parseInt(userInput[2]);
            case "-" -> Integer.parseInt(userInput[0]) - Integer.parseInt(userInput[2]);
            case "*" -> Integer.parseInt(userInput[0]) * Integer.parseInt(userInput[2]);
            case "/" -> Integer.parseInt(userInput[0]) / Integer.parseInt(userInput[2]);
            case "%" -> Integer.parseInt(userInput[0]) % Integer.parseInt(userInput[2]);
            default -> -1;
        };

        System.out.printf("\n%s %s %s = %d", userInput[0], userInput[1], userInput[2], result);
    }

    // check user input
    public static boolean checkInput(String[] userInput) {
        // if user input fails any validation, this variable will be 'false'
        boolean isCorrect = true;

        // according to the required format, there must be 3 elements in the array
        if (userInput.length != 3) {
            System.out.println("\nNeeded format: 1 + 1");
            isCorrect = false;

        /* at first we remove all the elements from 'first number' except digits,
           if after this there are any elements(digits), it means the user entered everything correctly

           userInput[0].equals("-") - this verification we need in case the user entered just '-' instead of normal digit */
        } else if (userInput[0].length() != userInput[0].replaceAll("[^0-9-]", "").length() ||
                userInput[0].equals("-")) {
            System.out.println("\nThere is a mistake in the first number: only numbers, not letters, please");
            isCorrect = false;

        // remove all the elements from 'sign' except signs which our calculator have
        } else if (userInput[1].replaceAll("[^+*/%-]", "").length() == 0) {
            System.out.println("\nThere is a mistake with the sign: available options: +, -, *, /, %, //");
            isCorrect = false;

        // same as 'userInput[0]'
        } else if (userInput[2].length() != userInput[2].replaceAll("[^0-9-]", "").length()  ||
                userInput[2].equals("-")) {
            System.out.println("\nThere is a mistake in the second number: only numbers, not letters, please");
            isCorrect = false;
        }

        return isCorrect;
    }
}
