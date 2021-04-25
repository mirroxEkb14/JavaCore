package Methods;

import java.util.Scanner;

public class CollatzConjecture {

    /**
     * Найдите число шагов, за которые получится единица,
     * используя следующий процесс: берём любое натуральное
     * число n больше единицы. Если оно чётное, то делим его
     * на 2, а если нечётное, то умножаем на 3 и прибавляем 1
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        int[] numberOfSteps;

        System.out.println("Enter a number:");
        userInput = scanner.nextInt();

        numberOfSteps = stepsNumber(userInput);

        System.out.printf("\nThe number of steps: %s\nTrue steps: %s",
                numberOfSteps[0], numberOfSteps[1]);
    }

    public static int[] stepsNumber(int n) {
        if (n <= 1) throw new IllegalArgumentException("Number cannot be <= 1");

        int[] steps = new int[2];
        int stepsCounter = 0;
        int trueStepsCounter = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = 3 * n + 1;
                trueStepsCounter++;
            }
            stepsCounter++;
        }

        steps[0] = stepsCounter;
        steps[1] = trueStepsCounter;

        return steps;
    }
}
