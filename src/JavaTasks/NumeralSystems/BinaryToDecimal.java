package JavaTasks.NumeralSystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args) {

        // read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary number:");
        String binaryNumber = scanner.nextLine();

        // get discharges
        List<Integer> discharges = new ArrayList<>();
        for (int i = 0; i < binaryNumber.length(); i++) {
            discharges.add(binaryNumber.length() - 1 - i);
        }

        // discharges under '0' in binary number must be omitted
        int counter = 0;
        int listSize = discharges.size();
        for (int i = 0; i < listSize; i++) {
            if (binaryNumber.charAt(i) == '0') {
                discharges.remove(i - counter);
                counter++;
            }
        }

        // raise '2' to the power of each discharge and add all the values
        int result = 0;
        for (int i: discharges) {
            result += Math.pow(2, i);
        }

        System.out.printf("\nBinary number %s in decimal system is %d", binaryNumber, result);
    }
}
