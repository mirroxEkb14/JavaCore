package JavaTasks.NumeralSystems;

import java.util.*;

public class HexadecimalToDecimal {

    public static void main(String[] args) {

        // ask user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hexadecimal number:");
        String hexadecimalNumber = scanner.nextLine(); // ex.: DF87

        // create a map with keys - hexadecimal numbers, values - decimal numbers
        Map<String, Integer> numbers = new HashMap<>();
        String[] hexadecimalNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        Integer[] decimalNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < 16; i++) {
            numbers.put(hexadecimalNumbers[i], decimalNumbers[i]);
        } // ex.: numbers = {A=10, B=11, C=12, D=13, E=14, F=15, 0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9}

        // get discharges
        List<Integer> discharges = new ArrayList<>();
        for (int i = hexadecimalNumber.length() - 1; i >= 0; i--) {
            discharges.add(i);
        } // ex.: discharges = [3, 2, 1, 0]

        /* do math:
        * first part of expression:            first part of expression:            first part of expression:           first part of expression:
        * i = 0                                i = 1                                i = 2                               i = 3
        * hexadecimalNumber.charAt(i) = 'D'    hexadecimalNumber.charAt(i) = 'F'    hexadecimalNumber.charAt(i) = '8'   hexadecimalNumber.charAt(i) = '7'
        * String.valueOf('D') = "D"            String.valueOf('F') = "F"            String.valueOf('8') = "8"           String.valueOf('7') = "7"
        * numbers.get("D") = 13                numbers.get("D") = 15                numbers.get("8") = 8                numbers.get("7") = 7
        *                                   ->                                  ->                                   ->
        * second part:                         second part:                         second part:                        second part:
        * discharges.indexOf(i) = 3            discharges.indexOf(i) = 2            discharges.indexOf(i) = 1           discharges.indexOf(i) = 0
        * Math.pow(16, 3) = 16^3               Math.pow(16, 2) = 16^2               Math.pow(16, 1) = 16^1              Math.pow(16, 0) = 16^0
        *
        * multiply two parts of expression:    multiply two parts of expression:    multiply two parts of expression:   multiply two parts of expression:
        * 13 * 16^3                            15 * 16^2                            8 * 16^1                            7 * 16^0                           */
        double result = 0;
        for (int i = 0; i < discharges.size(); i++) {
            result += numbers.get(String.valueOf(hexadecimalNumber.charAt(i))) * Math.pow(16, discharges.indexOf(i));
        }

        System.out.printf("Hexadecimal number %s in decimal system is %d", hexadecimalNumber, (int) result);
    }
}
