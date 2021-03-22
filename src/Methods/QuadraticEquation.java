package Methods;

import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'a', 'b' and 'c' variable: ");

        String[] variables = scanner.nextLine().replaceAll("[^0-9,-]", "").split(",");

        int a = Integer.parseInt(variables[0]);
        int b = Integer.parseInt(variables[1]);
        int c = Integer.parseInt(variables[2]);

        int d = b * b - 4 * a * c;

        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);

        System.out.printf("a -> %d\nb -> %d\nc -> %d\ndiscriminant -> %d\nx1 -> %.0f\nx2 -> %.0f",
                a, b, c, d, x1, x2);
    }
}
