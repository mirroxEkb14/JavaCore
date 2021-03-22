package JavaTasks.NumeralSystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        // ask user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter decimal number:");
        int decimalNumber = scanner.nextInt(); // ex.: 29

        // write the power of '2' till the power is greater than the number
        List<Double> numbersInPower = new ArrayList<>();
        double numberInPower;
        for (int i = 0; i < 1_000; i++) {
            numberInPower = Math.pow(2, i); // ex.: 2^0=1, 2^1=2, 2^2=4, 2^3=8, 2^4=16, 2^5=32

            if (numberInPower <= decimalNumber) { // ex.: 2^0=1, 2^1=2, 2^2=4, 2^3=8, 2^4=16 because all these numbers < 29
                numbersInPower.add(numberInPower);
            } else { // ex.: 2^5=32 because 32>29
                break;
            }
        }

        /* if we can subtract 'numberInPower' from 'decimalNumber'(number must be >= 0),
            we write '1', if not - '0' */
        StringBuilder result = new StringBuilder();

        /* from our 'decimalNumber' we need to subtract each number in 'numbersInPower' but
            starting from the end of the list(from more to less), from the result of subtraction
            we subtract a number from 'numbersInPower' again and so on  */
        double subtraction = decimalNumber; // ex.: subtraction=29
        for (int i = numbersInPower.size() - 1; i >= 0; i--) { // start from the end of the array
            subtraction -= numbersInPower.get(i); // ex.: 29-16=13, 13-8=5, 5-4=1, 1-2=-1, 1-1=0

            if (subtraction >= 0) { // ex.: 29-16=13, 13-8=5, 5-4=1  because all these numbers >= 0, then 1-1=0
                result.append(1);
            } else { // ex.: 1-2=-1 because this number < 0
                subtraction += numbersInPower.get(i); // ex.: here we assign 'subtraction' the previous value(1)
                result.append(0);
            }
        }

        System.out.printf("Decimal number %d in binary - %s", decimalNumber, result);
    }
}
